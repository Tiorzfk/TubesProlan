-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 17 Jul 2017 pada 00.45
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
  `noPolisi` varchar(8) NOT NULL,
  `merk` varchar(15) NOT NULL,
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
('33355666', 'Limausin', 'Putih', 2010, 200000, 500000, 100000, 0),
('ABC', 'Kijang III', 'Abu-abu', 2003, 100000, 200000, 15000, 0),
('D 888 BC', 'Honda Jazz', 'Putih', 2007, 180000, 250000, 50000, 0),
('D1405GC', 'Toyota Avanza', 'Putih', 2015, 150000, 250000, 12500, 0),
('D5555JM', 'Toyota Fortuner', 'Silver', 2012, 300000, 600000, 21000, 0),
('D6748GH', 'Nissan X-Trail ', 'Silver', 2010, 325000, 650000, 23000, 0),
('D7764HM', 'Toyota Yaris', 'Merah', 2013, 200000, 400000, 14000, 0),
('XYZ', 'Kijang Innova', 'Hitam', 2008, 110000, 220000, 30000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `noKTP` varchar(18) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `jenisKelamin` tinyint(1) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `pekerjaan` varchar(15) NOT NULL,
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
('1000155555', 'Noviyan Prayoga', 0, '1997-05-03', 'Developer', 'Jl Banten No.2', 3, '', '0891234567', 'noviyan.prayoga@gmail.com'),
('DBF199853095830066', 'Tatang Supriatna', 0, '1983-11-09', 'PNS', 'JL DIPATIUKUR NO.1534', 3, '', '0892454432', ''),
('GHK198914875198422', 'Jasmin Lestari', 1, '1989-10-11', 'Aktris', 'JL UJUNGBERUNG NO.4', 3, '0228476584', '088219479', 'jasmin.lestari@gmail.com');

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
(8, '2017-07-15', '2017-07-16', '2017-07-16', '200000', 0, 'DBF199853095830066', 'ABC'),
(9, '2017-07-18', '2017-07-25', '2017-07-16', '3500000', 0, '1000155555', '33355666'),
(10, '2017-07-15', '2017-07-16', '2017-07-16', '400000', 0, 'DBF199853095830066', 'D7764HM'),
(11, '2017-07-16', '2017-07-18', '2017-07-16', '440000', 0, 'DBF199853095830066', 'XYZ');

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
  MODIFY `idSewa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
