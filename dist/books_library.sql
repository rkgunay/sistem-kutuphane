-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2021 at 09:26 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `books_library`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` text COLLATE utf8_turkish_ci NOT NULL,
  `password` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `password`) VALUES
('admin', 'admin'),
('mct', 'mct');

-- --------------------------------------------------------

--
-- Table structure for table `books_database`
--

CREATE TABLE `books_database` (
  `id` int(11) NOT NULL,
  `book_name` text COLLATE utf8_turkish_ci NOT NULL,
  `book_writer` text COLLATE utf8_turkish_ci NOT NULL,
  `book_type` text COLLATE utf8_turkish_ci NOT NULL,
  `book_publisher` text COLLATE utf8_turkish_ci NOT NULL,
  `oduncte` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `books_database`
--

INSERT INTO `books_database` (`id`, `book_name`, `book_writer`, `book_type`, `book_publisher`, `oduncte`) VALUES
(1, 'Beyaz Zambaklar Ülkesinde', 'Grigoriy Petrov', 'Roman', 'Ay', 'Evet'),
(2, 'Peri Gazozu', 'Ercan Kesal', 'Roman', 'Güneş', 'Evet'),
(3, 'Simyacı', 'Paulo Coelho', 'Roman', 'Yıldız', 'Hayır'),
(4, 'Böğürtlen Kışı', 'Sarah Jio', 'Roman', 'Ay', 'Hayır'),
(7, 'Nietzsche Ağladığında', 'Irvin D. Yalom', 'Roman', 'Mars', 'Hayır'),
(10, 'İnce Memed', 'Yaşar Kemal', 'Roman', 'Ay', 'Hayır'),
(16, 'Kuyucuklu Yusuf', 'Sabahattin Ali', 'Roman', 'Mars', 'Evet'),
(33, 'Saatleri Ayarlama Enstitüsü', 'Ahmet Hamdi Tanpınar', 'Roman', 'Ay', 'Hayır'),
(34, 'Nutuk', 'Mustafa Kemal Atatürk', 'Roman', 'Marsa', 'Hayır'),
(49, 'Nutuk', 'Mustafa Kemal Atatürk', 'Roman', 'Mars', 'Evet'),
(51, 'Saatleri Ayarlama Enstitüsü', 'Ahmet Hamdi Tanpınar', 'Roman', 'Ayy', 'Hayır'),
(56, 'Nutuk', 'Mustafa Kemal Atatürk', 'Roman', 'Mars', 'Hayır'),
(66, 'Nutuk', 'Mustafa Kemal Atatürk', 'Roman', 'Mars', 'Hayır'),
(70, 'Saatleri Ayarlama Enstitüsü', 'Ahmet Hamdi Tanpınar', 'Roman', 'Ay', 'Hayır'),
(74, 'Nutuk', 'Mustafa Kemal Atatürk', 'Roman', 'Marsa', 'Hayır'),
(78, 'Nutuk', 'Mustafa Kemal Atatürk', 'Roman', 'Uzay', 'Hayır'),
(79, 'Kuyucuklu Yusuf', 'Sabahattin Ali', 'Roman', 'Mars', 'Hayır'),
(80, 'Böğürtlen Kışı', 'Sarah Jio', 'Roman', 'Ay', 'Hayır'),
(83, 'Kuyucuklu Yusuf', 'Sabahattin Ali', 'Roman', 'Mars', 'Hayır'),
(86, 'Saatleri Ayarlama Enstitüsü', 'Ahmet Hamdi Tanpınar', 'Roman', 'Ay', 'Hayır'),
(87, 'İnce Memed', 'Yaşar Kemal', 'Macera', 'Ay', 'Hayır');

-- --------------------------------------------------------

--
-- Table structure for table `ogrenci`
--

CREATE TABLE `ogrenci` (
  `id` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `password` text COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Dumping data for table `ogrenci`
--

INSERT INTO `ogrenci` (`id`, `password`) VALUES
('1170606011', '1170606011'),
('1170606010', '1170606010');

-- --------------------------------------------------------

--
-- Table structure for table `talepler`
--

CREATE TABLE `talepler` (
  `id` int(11) NOT NULL,
  `ogr_no` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `book_name` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `book_writer` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `book_publisher` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books_database`
--
ALTER TABLE `books_database`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `talepler`
--
ALTER TABLE `talepler`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books_database`
--
ALTER TABLE `books_database`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT for table `talepler`
--
ALTER TABLE `talepler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
