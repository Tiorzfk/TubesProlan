/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.utilities;

import static java.lang.Math.E;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author ASEP
 */

public class InputValidator {
    private String  fieldName    = "";
    
    private String  displayedMessage = "";
    
    /**
     * A list of [fieldName, field]
     */
    private Collection<Map<String, JComponent>> fields =
            new HashSet<Map<String, JComponent>>();
 
    /** 
     * [Rulename -> action] that will performed when user want verify all input
     */
    private Collection<Map<String, ActionValidator>> actions =
            new HashSet<Map<String, ActionValidator>>();
    /**
     * [Rulename -> message] that will displayed to end user when verify input
     * has performed
     */
    private Collection<Map<String, String>> messages =
            new HashSet<Map<String, String>>();
    /**
     * A list of builtin [rulename -> action]
     */
    private Collection<Map<String, ActionValidator>> builtinActions  =
            new HashSet<Map<String, ActionValidator>>();
    /**
     * A list of builtin [rulename -> message]
     */
    private Collection<Map<String, String>> builtinMessages =
            new HashSet<Map<String, String>>();
    
    /**
     * A list of [fieldName, rulename] that should performed
     * when checking input validity
     */
    private Collection<Map<String, String>> rules  =
            new HashSet<Map<String, String>>();
    
    /**
     * Constructor
     */
    public InputValidator() {
        initBuiltinRuleAction();
    }
    
    /**
     * You must call this once every want to adding rule to a field
     * 
     * @param field
     * @param name 
     */
    public void field(JComponent field, String name) {
        this.fieldName = name;
        
        this.fields.put(name, field);
    }
    
    /**
     * Call this after you finish adding rules to a field
     */
    public void end() {
        fieldName = "";
    }
    
    private void addRuleToCollection(String fieldName, String ruleName) {
        HashMap rule = new HashMap<String, String>();
        rule.put(fieldName, ruleName);
        rules.add(rule);
    }
    
    private boolean findRule(String ruleName) {
        for (Iterator<Map<String, ActionValidator>> iter = builtinActions.iterator(); iter.hasNext(); ) {
            Map<String, ActionValidator> element = iter.next();
           
        }
        return true;
    }
    
    /**
     * This method only accept builtin action
     * For list of builtin action, see initBuiltinRuleAction() method
     * 
     * @param rule
     * @param action
     * @throws Exception 
     */
    public void addRule(String ruleName, String action) throws Exception {        
        ruleName += "_" + action;
        if (builtinActions.get(ruleName) != null) {
            // attach the rule for validity check
            addRuleToCollection(fieldName, ruleName);
            return;
        }

        throw new Exception("Your rule is unknown.");
    }
    
    /**
     * This method only accept "valid_input" rule
     * 
     * @param rule
     * @param acceptableInput
     * @throws Exception 
     */
    public void addRule(String ruleName, String[] acceptableInput) throws Exception
    {
        if (ruleName.equals("valid_input") == false) {
            throw new Exception("Your rule must be `valid_input`");
        }
        
        // add new message for current rule
        messages.put(ruleName, "{fieldName} tidak valid");
        
        // add new action for current rule
        actions.put(ruleName, new ActionValidator() {
            public boolean verify(String val) {
                int i;
                boolean match = false;
                for (i = 0; i < acceptableInput.length; i++) {
                    if (acceptableInput[i].equals(val.trim())) {
                        match = true;
                        break;
                    }
                }
                return match;
            }
        });
        
        // attach the rule for validity check
        rules.put(fieldName, ruleName);
    }
    
    /**
     * Example of this is:
     *      addRule("required", true);
     * 
     * @param rule
     * @param value 
     */
    public void addRule(String ruleName, boolean bool) throws Exception {
        if (builtinActions.get(ruleName) == null) {
            throw new Exception("Your rule is unknown.");
        }
        
        // attach the rule for validity check
        if (bool) rules.put(fieldName, ruleName);
    }
    
    /**
     * RuleName must be unique, dont worry. This method will make it unique
     * 
     * @param ruleName
     * @param action
     * @param message 
     */
    public void addRule(
            String ruleName,
            ActionValidator action,
            String message
    ) {
        // make ruleName unique, if there is already ruleName
        Random rand = new Random();
        int number  = 1;
        while (actions.get(ruleName) != null) {
            ruleName    = ruleName + number;
            // 50 is the maximum and the 1 is our minimum 
            number      = rand.nextInt(50) + 1;
        }
        
        actions.put(ruleName, action);
        messages.put(ruleName, message);
        rules.put(fieldName, ruleName);
    }
    
    
    public boolean verifyAll() {
        System.out.println("size of map = " + rules.size());
        boolean isValid = true;
        for (Map.Entry<String, String> entry : rules.entrySet() ) {
            String fieldName = entry.getKey();
            String ruleName = entry.getValue();
            JComponent field = fields.get(fieldName);
            ActionValidator action = actions.get(ruleName);
            String inputValue = getInputValue(field);
            String message = messages.get(ruleName);
            System.out.println("fieldName = " + fieldName);
            System.out.println("ruleName = " + ruleName);
            System.out.println("field = " + field);
            System.out.println("action = " + action);
            
            if (! action.verify(inputValue)) {
                isValid = false;
                // add message to displayed to end user
                message = message.replace("{fieldName}", fieldName);
                displayedMessage += message + "\n";
            }
        }
        
        return isValid;
    }
    
    public String getInputValue(JComponent field) {
        if (field instanceof JComboBox) {
            return ((JComboBox) field)
                    .getSelectedItem().toString();
        }
            
        if (field instanceof JTextField) {
            return ((JTextField) field).getText();
        }
        
        return "";
    }
    
    public String getMessage() {
        return displayedMessage.replaceAll("\n",
                System.getProperty("line.separator"));
    }
    
    /**
     * Create builtin action
     */
    private void initBuiltinRuleAction() {
        builtinMessages.put("required", "{fieldName} tidak boleh kosong");
        builtinActions.put("required", new ActionValidator() {
            public boolean verify(String val) {
                return ! val.trim().equals("");
            }
        });
        
        builtinMessages.put("valid_input_numeric_only", "{feldName} hanya boleh "
                + "mengandung angka saja");
        builtinActions.put("valid_input_numeric_only", new ActionValidator() {
            public boolean verify(String val) {
                Pattern p = Pattern.compile("[^0-9]");
                return ! p.matcher(val).matches();
            }
        });
        
        builtinMessages.put("valid_input_character_only", "{fieldName} hanya boleh "
                + "mengandung huruf saja");
        builtinActions.put("valid_input_character_only", new ActionValidator() {
            public boolean verify(String val) {
                Pattern p = Pattern.compile("[^a-zA-Z]");
                return ! p.matcher(val).matches();
            }
        });
        
        builtinMessages.put("valid_input_alphanumeric_only", "{fieldName} hanya boleh "
                + "mengandung huruf dan angka saja");
        builtinActions.put("valid_input_alphanumeric_only", new ActionValidator() {
            public boolean verify(String val) {
                Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                return ! p.matcher(val).matches();
            }
        });
    }
}
