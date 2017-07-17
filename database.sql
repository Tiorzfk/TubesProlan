-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 17 Jul 2017 pada 15.52
-- Versi Server: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penyewaan_mobil`
--
CREATE DATABASE IF NOT EXISTS `penyewaan_mobil` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `penyewaan_mobil`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kota`
--

CREATE TABLE `kota` (
  `idKota` int(11) NOT NULL,
  `namaKota` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kota`
--

INSERT INTO `kota` (`idKota`, `namaKota`) VALUES
(2, 'Jakarta'),
(3, 'Bandung'),
(4, 'Jogja'),
(5, 'Belitung');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobil`
--

CREATE TABLE `mobil` (
  `noPolisi` varchar(9) NOT NULL,
  `merk` varchar(25) NOT NULL,
  `warna` varchar(10) NOT NULL,
  `tahun` year(4) NOT NULL,
  `hargaSewa12Jam` int(11) NOT NULL,
  `hargaSewa24Jam` int(11) NOT NULL,
  `dendaPerJam` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mobil`
--

INSERT INTO `mobil` (`noPolisi`, `merk`, `warna`, `tahun`, `hargaSewa12Jam`, `hargaSewa24Jam`, `dendaPerJam`, `status`) VALUES
('10005', 'Toyota Yaris II', 'Merah', 2008, 0, 100000, 30000, 0),
('D 888 JK', 'Toyota Avanza II', 'Hitam', 2011, 0, 150000, 50000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `noKTP` varchar(18) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `jenisKelamin` tinyint(1) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `pekerjaan` varchar(25) NOT NULL,
  `alamat` varchar(45) NOT NULL,
  `idKota` int(11) NOT NULL,
  `telepon` varchar(10) NOT NULL,
  `handphone` varchar(10) NOT NULL,
  `email` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`noKTP`, `nama`, `jenisKelamin`, `tanggalLahir`, `pekerjaan`, `alamat`, `idKota`, `telepon`, `handphone`, `email`) VALUES
('1000155555', 'Noviyan Prayoga', 0, '1997-05-03', 'Developer Mobile', 'Jl Banten No.2', 2, '', '0891234567', 'noviyan.prayoga@gmail.com'),
('DBF199853095830066', 'Tatang Supriatna', 0, '1983-11-09', 'PNS', 'JL DIPATIUKUR NO.1534', 3, '', '0892454432', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sewa`
--

CREATE TABLE `sewa` (
  `idSewa` int(11) NOT NULL,
  `tanggalSewa` date NOT NULL,
  `batasKembali` date NOT NULL,
  `tanggalKembali` date NOT NULL,
  `subTotal` varchar(8) NOT NULL,
  `denda` int(11) NOT NULL,
  `noKTP` varchar(18) NOT NULL,
  `noPolisi` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `sewa`
--

INSERT INTO `sewa` (`idSewa`, `tanggalSewa`, `batasKembali`, `tanggalKembali`, `subTotal`, `denda`, `noKTP`, `noPolisi`) VALUES
(14, '2017-07-15', '2017-07-16', '2017-07-17', '100000', 30000, '1000155555', '10005');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', 'admin'),
('kasir ', 'kasir');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kota`
--
ALTER TABLE `kota`
  ADD PRIMARY KEY (`idKota`);

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`noPolisi`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`noKTP`),
  ADD KEY `kota` (`idKota`);

--
-- Indexes for table `sewa`
--
ALTER TABLE `sewa`
  ADD PRIMARY KEY (`idSewa`),
  ADD KEY `noKTP` (`noKTP`),
  ADD KEY `noPolisi` (`noPolisi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kota`
--
ALTER TABLE `kota`
  MODIFY `idKota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `sewa`
--
ALTER TABLE `sewa`
  MODIFY `idSewa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
