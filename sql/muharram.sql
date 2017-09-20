-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2017 at 10:48 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `muharram`
--
CREATE DATABASE IF NOT EXISTS `muharram` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `muharram`;

-- --------------------------------------------------------

--
-- Table structure for table `kurs`
--

DROP TABLE IF EXISTS `kurs`;
CREATE TABLE `kurs` (
  `id_kurs` char(5) NOT NULL,
  `tgl` datetime DEFAULT NULL,
  `nominal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kurs`
--

INSERT INTO `kurs` (`id_kurs`, `tgl`, `nominal`) VALUES
('AUD', '2016-10-02 00:00:00', 9911.625),
('BND', '2016-10-02 00:00:00', 9521.665),
('EUR', '2016-10-02 00:00:00', 14578.57),
('GBP', '2016-10-02 00:00:00', 16847.37),
('HKD', '2016-10-02 00:00:00', 1676.08),
('IDR', '2014-10-25 11:06:36', 1),
('JPY', '2016-10-02 00:00:00', 128.7378),
('MYR', '2016-10-02 00:00:00', 3136.59),
('SGD', '2016-10-02 00:00:00', 9521.665),
('USD', '2016-10-02 00:00:00', 12998);

-- --------------------------------------------------------

--
-- Table structure for table `ms_shodaqoh`
--

DROP TABLE IF EXISTS `ms_shodaqoh`;
CREATE TABLE `ms_shodaqoh` (
  `id_shodaqoh` int(11) NOT NULL COMMENT 'Pattern "IS-00"',
  `jenis` varchar(45) DEFAULT NULL COMMENT 'Harta, Uang, Area, dll',
  `satuan` varchar(5) DEFAULT NULL,
  `keterangan` varchar(45) DEFAULT NULL COMMENT 'Misal uang itu ada mata uang Dollar US, dll'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ms_shodaqoh`
--

INSERT INTO `ms_shodaqoh` (`id_shodaqoh`, `jenis`, `satuan`, `keterangan`) VALUES
(1, 'Uang', 'IDR', 'uang rupiah'),
(2, 'Uang', 'MYR', 'uang ringgit malaysia'),
(3, 'Uang', 'USD', 'uang dollar amerika'),
(4, 'Uang', 'SGD', 'uang dollar singapore'),
(5, 'Uang', 'AUD', 'uang dollar australia'),
(6, 'Uang', 'JPY', 'uang yen jepang'),
(7, 'Uang', 'BND', 'uang dollar brunei'),
(8, 'Uang', 'EUR', 'uang euro'),
(9, 'Uang', 'GBP', 'uang british pound'),
(10, 'Uang', 'HKD', 'uang dollar hongkong'),
(11, 'Emas', 'GRAM', 'satuan dasar timbangan untuk emas/perhiasan'),
(12, 'Alat komunikasi', 'unit', NULL),
(13, 'Uang', 'DINAR', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `penyumbang`
--

DROP TABLE IF EXISTS `penyumbang`;
CREATE TABLE `penyumbang` (
  `id_penyumbang` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL COMMENT 'Full name',
  `alamat` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penyumbang`
--

INSERT INTO `penyumbang` (`id_penyumbang`, `nama`, `alamat`) VALUES
(1, 'keluarga Abi Tsabit', ''),
(2, 'pendamping MI', ''),
(3, 'paud dan mi sekolah kita', 'cibanoang'),
(4, 'MI Al-Zaytun', 'Al-Zaytun'),
(5, 'dinjantri', 'jawa timur'),
(6, 'pagayuban wali santri', 'jawa tengah'),
(7, 'Adhietya Noegraha', 'JAMBI'),
(8, 'Paguyuban alumni hockey Al-Zaytun', ''),
(9, 'Paguyuban alumni hockey Al-Zaytun', ''),
(10, 'majlis Ta''lim Al-Bakri', 'Cipondoh Tanggerang'),
(11, 'FTI UAZ', 'Jakarta'),
(12, 'Masyarakat Jakata', 'Jakarta'),
(13, 'Koordinator Sulawesi Tengah', 'Sulawesi Tengah'),
(14, 'Lukman h dkk', 'MAZ'),
(15, 'paguyuban wali santri', 'banten'),
(16, 'Koordinator Lampung', 'Lampung'),
(17, 'paguyuban wali santri', 'banten'),
(18, 'suhendi', 'Jakarta Utara'),
(19, 'usman', 'Aceh'),
(20, 'Masyarakat', 'Nuskin Indonesia'),
(21, 'Jamaah guru Al-Zaytun', ''),
(22, 'nahadi', 'riau'),
(23, 'mahasiswa IAI al-azis', 'Al-zaytun Gantar Indramayu'),
(24, 'H. Gatot Boedi H', ''),
(25, 'Farhan', 'Jakarta Timur'),
(26, 'Santri Mahad Al-Zaytun', 'Indramayu, Mahad Al-Zaytun'),
(27, 'koordinator', 'jawa barat'),
(28, 'Pembangunan MAZ', ''),
(29, 'Bambang Triyoga', 'Pembangunan'),
(30, 'Hilman M Suaidi', ''),
(31, 'M.Natsir Juaidy', ''),
(32, 'Yayasan al tarbiyah', 'malaysia/singapura'),
(33, 'kel Audi dan Woro', 'Depok'),
(34, 'yayasan tltarbiyah', 'malaysia/singapura'),
(35, 'Ibu Miming Merina', 'Warung Sidoarjo'),
(36, 'Umi', 'Lampung'),
(37, 'IHK', 'Indonesia harus kuat'),
(38, 'Sugiyono', 'Jogja'),
(39, 'Umi Tasik', 'Tasikmalaya'),
(40, 'tahmid tiriapradja', 'bandung'),
(41, 'yayasan al tarbiyah', 'malaysia/singapura'),
(42, 'Ibu Miming Merina', 'Warung Sidoarjo'),
(43, 'ibu hj titing saomi', 'bandung'),
(44, 'Wahyu Wisnu', 'Tamica'),
(45, 'Sri', 'Gabel'),
(46, 'Amar', 'Malaysia'),
(47, 'muhammad amirudin hanif', 'jambi'),
(48, 'Ketahanan Pangan Sukabumi', 'Sukabumi'),
(49, 'Hamba Allah', ''),
(50, 'Adiyanto', 'Jakarta Selatan'),
(51, 'Keluarga Khoirul Izza M', 'Bogor'),
(52, 'aziz shukri', 'malaysia'),
(53, 'Marsono', 'Bandung'),
(54, 'Danish', ''),
(55, 'Hamba Allah', ''),
(56, 'Danish Qunata', 'Bekasi'),
(57, 'yayasan al tarbiyah', 'malaysia/singapura'),
(58, 'Hamba Allah', ''),
(59, 'suwarno', ''),
(60, 'rasyid shiddiq', 'serang banten'),
(61, 'Mumtaz', 'Bekasi'),
(62, 'Agung', ''),
(63, 'Keluarga besar hockey Al-Zaytun', 'Al-Zaytun'),
(64, 'IHK', 'Indonesia harus kuat'),
(65, 'Marakarimah', 'NTB'),
(66, 'Akbar Cell', 'Cikupa'),
(67, 'muthia haifa rahma', 'serang banten'),
(68, 'Desi Arisandi', 'Jakarta'),
(69, 'Fatma Sari Dewi', 'Jakarta'),
(70, 'arif', 'kendal'),
(71, 'Hamba Allah', 'Jakarta'),
(72, 'Bambang Triyoga', ''),
(73, 'Mukjizah', 'Jakarta Utara'),
(74, 'FTI UAZ', 'Jakarta'),
(75, 'Masyarakat Jakarta', 'Jakarta'),
(76, 'H.duyeh abdullah hidayat', 'Bandung'),
(77, 'Hamba Allah', ''),
(78, 'Enay', 'Jakarta'),
(79, 'IHK', 'Indonesia harus kuat'),
(80, 'Abdur Rochim', 'WS Bandung Paguyuban '),
(81, 'Bambang Triyoga', 'Pembangunan'),
(82, 'PT.Asafa karya secaras', 'Jakarta'),
(83, 'Ibu Miming Merina', 'Warung Sidoarjo'),
(84, 'Kel.Sondry', 'Bandung'),
(85, 'Refan & Naufal', 'Bandung'),
(86, 'LukmanH DKK', 'MAZ'),
(87, 'Nahadi', 'riau'),
(88, 'Zulhilmi', 'Malaysia'),
(89, 'Eddy Djamaludin Suaidy  beserta warga tani ', 'Kampung 99 Pepohonan '),
(90, 'usman', 'Aceh'),
(91, 'MI Al-Zaytun', 'Al-Zaytun'),
(92, 'Alumni Al-Zaytun', 'Malaysia'),
(93, 'Ziki', ''),
(94, 'Abdul Icnodin', 'Mewakili relawan Al-Zaytun'),
(95, 'Ziki', 'Kuningan'),
(96, 'Muhammad Husein', 'Jambi'),
(97, 'Mumtaz', 'Bekasi'),
(98, 'Ask Saeful karim', 'Bali'),
(99, 'M.Taufik', 'Depok'),
(100, 'Jamil Abdil Ghani', 'Malaysia'),
(101, 'Yayasan al tarbiyah', 'Malaysia/Singapura'),
(102, 'Ask Saeful Karim', 'Bali'),
(103, 'Sultan M. Akbar', 'MI Kelas 4'),
(104, 'Hj. Dhurrotully', 'Gersik'),
(105, 'Ask Syaeful Karim', 'Bali'),
(106, 'kuplay', 'jakarta'),
(107, 'kuplay', ''),
(108, 'agnia', 'suriah'),
(109, 'kuplay', 'Zimbabwe'),
(110, 'nona ramadhani', 'new jersey'),
(111, 'Nona', 'Haurkolot'),
(112, 'ikmal', 'gantar'),
(113, 'ikmal', 'dunia lain'),
(114, 'agnia', 'depan gate'),
(115, 'Afrida', 'Jayabaya'),
(116, 'Nicholas', 'Dallas'),
(117, 'zamani', 'flat earth'),
(118, 'Fathona', 'Dubai'),
(119, 'bibil', 'jantung hatiku'),
(120, 'Sabila', 'Qatar'),
(121, 'andi', 'jakarta selatan'),
(122, 'Budi', 'kalimantan'),
(123, 'alfi', 'jawa barat'),
(124, 'yoyo', 'jambi'),
(125, 'joyo', 'surabaya'),
(126, 'joyo', 'surabaya'),
(127, 'udin', 'jakarta'),
(128, 'suhujing', 'jepang'),
(129, 'afrida', 'jabar'),
(130, 'Osama', 'Afghanistan'),
(131, 'akfas', 'afaf'),
(132, 'fadli', 'pekolongan'),
(133, 'Khaddafi', ''),
(134, 'tim pengawas', 'al-zaytun'),
(135, 'Zamani', 'antah berantah'),
(136, 'yasir', 'semarang'),
(137, 'yasir', 'semarang'),
(138, 'imam prawoto', 'ketua YPI '),
(139, 'cabang hockey', 'al-zaytun'),
(140, 'Santri Mts-MA', 'Al-Zaytun, Indonesia'),
(141, 'Satria Usaha Kerja', 'Al Zaytun Indonesia'),
(142, 'Santri MI', 'Al-Zaytun'),
(143, 'Jama''ah Guru', 'Al Zaytun, Indonesia'),
(144, 'yayasan al-tarbiyah', 'malaysia'),
(145, 'Relawan Perkhidmatan', 'Al-Zaytun, Indonesia'),
(146, 'Santri Cibanoang', 'Al Zaytun, Indonesia'),
(147, 'Raja Kamarul Isham', 'Malaysia'),
(148, 'abdullah arif', 'ukm pantai selatan jateng'),
(149, 'Tim Unit Armada', 'Al Zaytun, Indonesia(uang di YPI)'),
(150, 'Tim Pengawas', 'Al-Zaytun, Indonesia'),
(151, 'Setia Usaha Kerja', 'Al Zaytun, Indonesia(uang di YPI)'),
(152, 'Tim Unit Beras', 'Al-Zaytun, Indonesia (uang di YPI)'),
(153, 'Santri Mts-MA', 'Al-Zaytun, Indonesia (uang di YPI)'),
(154, 'Santri MI', 'Al-Zaytun, Indonesia (uang di YPI)'),
(155, 'Tim Unit Pembangunan', 'Al Zaytun, Indonesia(uang di YPI)'),
(156, 'Relawan Perkhidmatan', 'Al-Zaytun, Indonesia ( uang di YPI)'),
(157, 'Tim Pengawas', 'Al-Zaytun, Indonesia (uang di YPI)'),
(158, 'Kartini', 'RMK Cikopo'),
(159, 'Tim Kultur Jaringan', 'Al Zaytun, Indonesia(uang di YPI)'),
(160, 'Eksponen non LKM', 'Al-Zaytun, Indonesia (uang di YPI)'),
(161, 'Lembaga Kesejahteraan Masjid (LKM)', 'Al-Zaytun, Indonesia (uang di YPI)'),
(162, 'Hamba Allah', 'Al Zaytun, Indonesia'),
(163, 'Timm Unit HIUIK', 'Al-Zaytun, Indonesia (uang di YPI)'),
(164, 'yayasan al-tarbiyah', 'malaysia'),
(165, 'Tim Unit HIUIK', 'Al-Zaytun, Indonesia (uang di YPI)'),
(166, 'Singapura', 'Singapura'),
(167, 'UMKM Pantura', ''),
(168, 'alm.bah sayad bin saglan', 'bekasi'),
(169, 'Koordinator', 'Banten'),
(170, 'Wali Murid Assifa Nur A', 'Bekasi'),
(171, 'cabang hockey', 'al-zaytun'),
(172, 'Mariadi', 'Jambi'),
(173, 'abdullah arif', 'ukm pantai selatan jateng'),
(174, 'H. Tagor Mulia', 'Jambi'),
(175, 'M.Husein', 'jambi'),
(176, 'M. Rochani Spd.', 'Jambi'),
(177, 'Alumni Al-Zaytun Angkatan 1,2,5', 'Al-Zaytun'),
(178, 'suwarmi', 'cikarang'),
(179, 'Ihsan', 'Medan SuMut'),
(180, 'Mahasiwa IAI Al-Aziz', ''),
(181, 'Abdul Karim', 'Koordinator Bengkulu'),
(182, 'Bank DFG', ''),
(183, 'Hamba Allah', 'Bekasi'),
(184, 'Din Suryo', 'Paguyuban Jawa Timur'),
(185, 'nahadi', 'riau'),
(186, 'Datuk Muhammad Nurdin & H. Momon Kusman', 'Palembang'),
(187, 'Setia Usaha Kerja', 'Al Zaytun Indonesia'),
(188, 'keluarga fekie', 'jambi'),
(189, 'Raja Kamarul Izham', 'Malaysia'),
(190, 'Usman', 'Aceh'),
(191, 'imam prawoto', 'ketua ypi'),
(192, 'Pendamping dan wali santri MI Asrama Persaahabatan', ''),
(193, 'PT. Asfa karya', 'jakarta'),
(194, 'Hamba Allah', 'Jambi'),
(195, 'Yudha Fauzi', 'Sulawesi Tengah'),
(196, 'burhanudin', 'sumatra selatan'),
(197, 'Hamba Allah', 'Jakarta'),
(198, 'Hamba Allah', 'Bekasi'),
(199, 'jiki & nissa', 'jakarta'),
(200, 'Haddy Kurniawan(Wali Santri)', 'Medan, SuMut'),
(201, 'Amin tasdiq', 'Jawa Barat Selatan'),
(202, 'Suherman', 'jakarta'),
(203, 'koordinator', 'jawa barat'),
(204, 'Pandeglang', 'Pandeglang'),
(205, 'chandra Jaya', 'lampung'),
(206, 'arifa amanda', 'serang'),
(208, 'H. Tagor Mulia ', 'Jambi'),
(209, 'koordinator', 'lampung'),
(211, ' ', 'Pandeglang'),
(212, 'Anis Khairunisa', 'Ma''had Al-Zaytun'),
(213, 'Pendamping dan wali santri MI Asrama Persaahabatan', 'Ma''had Al-Zaytun'),
(214, 'hamba Allah', 'gresik'),
(215, 'Hamba Allah', 'Bekasi'),
(216, 'arifa amanda', 'serang'),
(217, 'Koordinator', 'Banten'),
(218, 'Santri MI', 'Al-Zaytun'),
(219, 'Santri Mts-MA', 'Al-Zaytun, Indonesia ');

-- --------------------------------------------------------

--
-- Table structure for table `tahun_aktif`
--

DROP TABLE IF EXISTS `tahun_aktif`;
CREATE TABLE `tahun_aktif` (
  `tahun` char(4) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tahun_aktif`
--

INSERT INTO `tahun_aktif` (`tahun`, `status`) VALUES
('1433', 0),
('1434', 0),
('1436', 0),
('1438', 0),
('1439', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tr_shodaqoh`
--

DROP TABLE IF EXISTS `tr_shodaqoh`;
CREATE TABLE `tr_shodaqoh` (
  `id_transaksi` int(11) NOT NULL,
  `nomor_transaksi` char(5) DEFAULT NULL,
  `tahun` char(4) DEFAULT NULL,
  `operator` varchar(21) DEFAULT NULL COMMENT 'nickname (username)',
  `penyumbang` int(11) DEFAULT NULL,
  `shodaqoh` int(11) NOT NULL,
  `jumlah` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tr_shodaqoh`
--

INSERT INTO `tr_shodaqoh` (`id_transaksi`, `nomor_transaksi`, `tahun`, `operator`, `penyumbang`, `shodaqoh`, `jumlah`) VALUES
(1, '022', '1438', 'fathona', 209, 1, 5000000),
(2, '080', '1438', 'fathona', 203, 1, 52000000),
(3, '010', '1438', 'afrida', 165, 1, 1600000),
(4, '082', '1438', 'yasir', 185, 1, 2500000),
(5, '011', '1438', 'zamani', 159, 1, 300000),
(6, '003', '1438', 'afrida', 161, 1, 41450000),
(7, '012', '1438', 'zamani', 155, 1, 23670000),
(8, '068', '1438', 'ikmal', 212, 1, 2000000),
(9, '004', '1438', 'afrida', 160, 1, 1700000),
(10, '023', '1438', 'sabila', 195, 1, 500000),
(11, '009', '1438', 'afrida', 152, 1, 3440000),
(12, '006', '1438', 'zamani', 151, 1, 925000),
(13, '081', '1438', 'fathona', 202, 1, 477396000),
(14, '007', '1438', 'afrida', 157, 1, 650000),
(15, '002', '1438', 'afrida', 189, 1, 300000),
(16, '008', '1438', 'zamani', 149, 1, 2200000),
(18, '017', '1438', 'afrida', 156, 1, 2000000),
(19, '014', '1438', 'zamani', 146, 1, 1980000),
(20, '036', '1438', 'ikmal', 201, 1, 22000000),
(21, '084', '1438', 'naufal', 179, 1, 500000),
(22, '020', '1438', 'afrida', 218, 1, 8191000),
(23, '013', '1438', 'zamani', 143, 1, 34734000),
(24, '110', '1438', 'afrida', 219, 1, 45475000),
(26, '021', '1438', 'zamani', 187, 1, 300000),
(28, '035', '1438', 'yasir', 171, 1, 15089000),
(30, '088', '1438', 'fathona', 199, 1, 2000000),
(31, '057', '1438', 'sabila', 208, 1, 1000000),
(32, '079', '1438', 'Agnia', 184, 1, 92500000),
(33, '085', '1438', 'fathona', 196, 1, 500000),
(34, '083', '1438', 'naufal', 190, 1, 400000),
(35, '024', '1438', 'sabila', 217, 1, 97150000),
(37, '037', '1438', 'yasir', 164, 3, 12000),
(38, '087', '1438', 'Agnia', 181, 1, 500000),
(40, '089', '1438', 'ikmal', 205, 1, 1000000),
(41, '061', '1438', 'naufal', 182, 1, 1000000),
(42, '025', '1438', 'yasir', 173, 1, 23900000),
(43, '090', '1438', 'Agnia', 166, 4, 1882),
(44, '093', '1438', 'fathona', 193, 1, 10000000),
(45, '092', '1438', 'sabila', 167, 1, 25100000),
(46, '060', '1438', 'naufal', 186, 1, 27500000),
(47, '027', '1438', 'ikmal', 213, 1, 10000000),
(48, '094', '1438', 'fathona', 180, 1, 10395000),
(49, '066', '1438', 'naufal', 211, 1, 500000),
(50, '095', '1438', 'Agnia', 177, 1, 10000000),
(51, '063', '1438', 'naufal', 158, 1, 1700000),
(52, '097', '1438', 'Agnia', 172, 1, 1000000),
(54, '099', '1438', 'fathona', 175, 1, 2000000),
(55, '098', '1438', 'zamani', 162, 1, 2000000),
(56, '045', '1438', 'naufal', 169, 3, 1500),
(57, '091', '1438', 'fathona', 168, 1, 1000000),
(58, '096', '1438', 'Agnia', 170, 1, 500000),
(60, '069', '1438', 'yasir', 191, 1, 2500000),
(61, '062', '1438', 'yasir', 214, 1, 1000000),
(62, '100', '1438', 'ikmal', 176, 1, 250000),
(63, '101', '1438', 'yasir', 178, 1, 500000),
(64, '049', '1438', 'fathona', 188, 1, 500000),
(65, '102', '1438', 'Agnia', 194, 1, 20000),
(66, '103', '1438', 'ikmal', 197, 1, 350000),
(67, '046', '1438', 'naufal', 200, 1, 500000),
(70, '065', '1438', 'sabila', 215, 1, 100000),
(71, '105', '1438', 'yasir', 216, 1, 50000);

-- --------------------------------------------------------

--
-- Table structure for table `tr_shodaqoh_1436`
--

DROP TABLE IF EXISTS `tr_shodaqoh_1436`;
CREATE TABLE `tr_shodaqoh_1436` (
  `id_transaksi` int(11) NOT NULL DEFAULT '0',
  `nomor_transaksi` char(5) CHARACTER SET latin1 DEFAULT NULL,
  `tahun` char(4) CHARACTER SET latin1 DEFAULT NULL,
  `operator` varchar(21) CHARACTER SET latin1 DEFAULT NULL COMMENT 'nickname (username)',
  `penyumbang` int(11) DEFAULT NULL,
  `shodaqoh` int(11) NOT NULL,
  `jumlah` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tr_shodaqoh_1436`
--

INSERT INTO `tr_shodaqoh_1436` (`id_transaksi`, `nomor_transaksi`, `tahun`, `operator`, `penyumbang`, `shodaqoh`, `jumlah`) VALUES
(1, '001', '1436', 'fitri', 1, 1, 10000000),
(2, '004', '1436', 'niitin', 2, 1, 6820000),
(3, ' 002', '1436', 'nabila', 91, 1, 7300000),
(4, '027', '1436', 'nadya', 89, 1, 36900000),
(5, '017a', '1436', 'hanif', 9, 1, 3199000),
(6, '090', '1436', 'sri', 75, 1, 497711000),
(7, '003', '1436', 'shofa', 3, 1, 1866000),
(8, '034', '1436', 'razan', 16, 1, 3000000),
(9, '022', '1436', 'nadya', 96, 1, 2000000),
(10, '017b', '1436', 'hanif', 8, 2, 50),
(11, '065', '1436', 'irfan', 5, 1, 71000000),
(13, '024', '1436', 'shofa', 6, 1, 51000000),
(15, '020', '1436', 'fitrah', 7, 1, 5000000),
(17, '025', '1436', 'nadya', 94, 1, 53811000),
(18, '027A', '1436', 'razan', 13, 1, 1000000),
(19, '005', '1436', 'fitri', 10, 1, 1500000),
(20, '023', '1436', 'niitin', 11, 1, 2730000),
(21, '066', '1436', 'nabila', 86, 1, 1500000),
(22, '026a', '1436', 'ichsan', 15, 1, 132045000),
(23, '026b', '1436', 'ichsan', 17, 3, 1500),
(24, '019', '1436', 'fitri', 18, 1, 1000000),
(25, '067', '1436', 'hanif', 20, 1, 25000000),
(26, '038', '1436', 'nabila', 87, 1, 800000),
(27, '1111', '1436', 'hanif', 21, 1, 33800000),
(28, '070', '1436', 'sri', 71, 1, 80000000),
(29, '035', '1436', 'shofa', 23, 1, 10000000),
(30, '078', '1436', 'sri', 100, 1, 500000),
(31, '071', '1436', 'razan', 25, 1, 1200000),
(32, '165', '1436', 'hanif', 24, 1, 1000000),
(33, '011', '1436', 'irfan', 26, 1, 34000000),
(34, '068', '1436', 'ichsan', 27, 1, 35500000),
(35, '163', '1436', 'hanif', 28, 1, 2000000),
(36, '040', '1436', 'sri', 105, 1, 400000),
(37, '009', '1436', 'nadya', 104, 1, 600000),
(38, '157', '1436', 'fitri', 81, 1, 500000),
(39, '166', '1436', 'fitrah', 30, 1, 1000000),
(40, '041', '1436', 'hanif', 73, 1, 1000000),
(41, '074', '1436', 'sri', 95, 1, 1000000),
(42, '083', '1436', 'sri', 92, 1, 8000000),
(43, '164', '1436', 'fitrah', 31, 1, 1000000),
(44, '167A', '1436', 'niitin', 101, 3, 21500),
(45, '073', '1436', 'shofa', 33, 1, 2000000),
(46, '042', '1436', 'sri', 84, 1, 1000000),
(47, '085', '1436', 'sri', 78, 1, 1300000),
(48, '167B', '1436', 'niitin', 57, 4, 1660),
(49, '088', '1436', 'hanif', 36, 1, 2000000),
(50, '086', '1436', 'fitrah', 38, 1, 50000),
(51, '006', '1436', 'irfan', 39, 1, 1000000),
(52, '008', '1436', 'ichsan', 40, 1, 500000),
(53, '007', '1436', 'ichsan', 43, 1, 500000),
(54, '084', '1436', 'fitri', 44, 1, 1000000),
(55, '043', '1436', 'fitri', 45, 1, 100000),
(56, '092', '1436', 'niitin', 46, 1, 185000),
(57, '089', '1436', 'ichsan', 47, 1, 250000),
(58, '028', '1436', 'irfan', 48, 1, 500000),
(59, '031', '1436', 'hanif', 49, 1, 100000),
(60, '030', '1436', 'razan', 50, 1, 200000),
(61, '029', '1436', 'hanif', 51, 1, 500000),
(62, '082', '1436', 'shofa', 52, 2, 88600),
(63, '093', '1436', 'razan', 53, 1, 150000),
(64, '23', '1436', 'nadya', 74, 1, 2370000),
(65, '044', '1436', 'razan', 85, 1, 500000),
(66, '010', '1436', 'hanif', 55, 1, 100000),
(67, '081', '1436', 'nadya', 80, 1, 30000000),
(69, '032', '1436', 'hanif', 58, 1, 200000),
(70, '012', '1436', 'fitri', 59, 1, 50000),
(71, '075', '1436', 'ichsan', 60, 1, 100000),
(72, '013', '1436', 'sri', 88, 1, 200000),
(73, '172', '1436', 'irfan', 62, 1, 200000),
(74, '015', '1436', 'nadya', 99, 1, 150000),
(75, '069', '1436', 'hanif', 63, 1, 7168000),
(76, '087', '1436', 'nabila', 76, 1, 500000),
(77, '080', '1436', 'nabila', 79, 1, 400000),
(78, '016', '1436', 'niitin', 65, 1, 100000),
(79, '072', '1436', 'nabila', 82, 1, 3500000),
(80, '095', '1436', 'hanif', 66, 1, 300000),
(81, '037', '1436', 'nabila', 90, 1, 500000),
(82, '094', '1436', 'ichsan', 67, 1, 100000),
(83, '097', '1436', 'irfan', 68, 1, 200000),
(84, '098', '1436', 'nabila', 70, 1, 100000),
(85, '096', '1436', 'niitin', 69, 1, 100000),
(86, '014', '1436', 'nadya', 103, 1, 250000),
(88, '099', '1436', 'irfan', 77, 1, 100000),
(89, '091', '1436', 'fitri', 83, 1, 400000),
(90, '33', '1436', 'niitin', 97, 1, 250000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(21) NOT NULL,
  `password` varchar(45) NOT NULL,
  `privilege` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `privilege`) VALUES
('afrida', '313212a1870215e863a9da1859fbaa6e53f50670', 1),
('agnia', '0e18f44c1fec03ec4083422cb58ba6a09ac4fb2a', 1),
('dafrizal', '2736fab291f04e69b62d490c3c09361f5b82461a', 1),
('fadli', 'b7103408c39c38c4ebd96669e62616e07afac6a7', 1),
('fathona', '1589b5b5c0433937d5932583a34b1e5562d8e054', 1),
('fitrah', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('fitri', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('hanif', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('ichi', 'ichiichi', 0),
('ichsan', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('ikmal', '138c50c4a468edcd8f80f4e5d84a721f8ae767e3', 1),
('ilyas', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('ines', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('irfan', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('kartini', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('lelawati', 'lalalelalala', 0),
('mauji', '7e87ef124a4e96ccaea057ed975dd42743689e3f', 1),
('nabila', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('nadra', 'nadranadra', 0),
('nadya', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('naufal', 'dc724af18fbdd4e59189f5fe768a5f8311527050', 1),
('niitin', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('rahman', 'rahmanrahman', 0),
('razan', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('reza', 'rezareza', 0),
('rifki', '4d03ebb840218e2dc8733e450178727c47b99d17', 1),
('root', 'anakpisang', 0),
('sabila', '4a89d39fb6c100398f16db6bae7e9e7b9d602c98', 1),
('shofa', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('sri', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc', 1),
('testing', 'dc724af18fbdd4e59189f5fe768a5f8311527050', 1),
('thoha', '814b1bd7a0e652a3afb04cede6df9510d6a32467', 15),
('yasir', 'dc724af18fbdd4e59189f5fe768a5f8311527050', 1),
('zamani', '18597ac51bf82376f52715d650bfed1d6ea19559', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kurs`
--
ALTER TABLE `kurs`
  ADD PRIMARY KEY (`id_kurs`);

--
-- Indexes for table `ms_shodaqoh`
--
ALTER TABLE `ms_shodaqoh`
  ADD PRIMARY KEY (`id_shodaqoh`);

--
-- Indexes for table `penyumbang`
--
ALTER TABLE `penyumbang`
  ADD PRIMARY KEY (`id_penyumbang`);

--
-- Indexes for table `tahun_aktif`
--
ALTER TABLE `tahun_aktif`
  ADD PRIMARY KEY (`tahun`);

--
-- Indexes for table `tr_shodaqoh`
--
ALTER TABLE `tr_shodaqoh`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD UNIQUE KEY `nomor_transaksi` (`nomor_transaksi`,`tahun`),
  ADD KEY `fk_tr_shodaqoh_ms_shodaqoh` (`shodaqoh`),
  ADD KEY `fk_tr_shodaqoh_penyumbang1` (`penyumbang`),
  ADD KEY `fk_tr_shodaqoh_users` (`operator`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ms_shodaqoh`
--
ALTER TABLE `ms_shodaqoh`
  MODIFY `id_shodaqoh` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Pattern "IS-00"', AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `penyumbang`
--
ALTER TABLE `penyumbang`
  MODIFY `id_penyumbang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=220;
--
-- AUTO_INCREMENT for table `tr_shodaqoh`
--
ALTER TABLE `tr_shodaqoh`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tr_shodaqoh`
--
ALTER TABLE `tr_shodaqoh`
  ADD CONSTRAINT `fk_tr_shodaqoh_ms_shodaqoh` FOREIGN KEY (`shodaqoh`) REFERENCES `ms_shodaqoh` (`id_shodaqoh`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tr_shodaqoh_penyumbang1` FOREIGN KEY (`penyumbang`) REFERENCES `penyumbang` (`id_penyumbang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tr_shodaqoh_users` FOREIGN KEY (`operator`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
