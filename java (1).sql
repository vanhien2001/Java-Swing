-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 16, 2021 lúc 04:10 PM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `id_booking` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `id_staff` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`id`, `id_booking`, `Price`, `id_staff`, `Date`) VALUES
(3, 15, 350, 12, '2021-05-09 08:47:50'),
(9, 31, 505, 19, '2021-05-16 14:05:28');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_room` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_staff` int(11) NOT NULL,
  `Payed` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `booking`
--

INSERT INTO `booking` (`id`, `id_customer`, `id_room`, `Date`, `id_staff`, `Payed`) VALUES
(15, 20, 12, '2021-05-09 08:46:34', 12, 1),
(17, 22, 14, '2021-05-09 09:43:27', 12, 1),
(20, 25, 33, '2021-05-11 14:55:50', 12, 1),
(30, 35, 24, '2021-05-16 14:04:01', 18, 0),
(31, 36, 21, '2021-05-16 14:04:40', 18, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `Name` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sdt` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Cmnd` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Address` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `Name`, `Sdt`, `Cmnd`, `Address`) VALUES
(20, 'NVH', '0969696969', '12345678910', 'xx/xx/xxxxxxx/xxxxx'),
(21, 'Nguyễn Văn A', '0969696969', '12345678910', 'xxxxxxxxxxxxx'),
(22, 'Văn A', '0969696969', '12345678910', 'xxxxxxxxxxxxxx'),
(23, 'aaaaaaaaaaaaaaaaaaaa', '1234567891', '12345678910', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'),
(24, 'qqqqqqqqqqqqqqq', '1234567891', '12345678910', 'qwerasdfzxcv'),
(25, 'aza', '1234567981', '1234567981', '1234567981'),
(26, 'vjvj', '1234567981', '1234567981', '1234567981'),
(27, 'aaa', '1234567891', '1234567891', '1234567891'),
(28, 'h', '1234567891', '1234567891', '1234567891'),
(29, 'a', '1234567891', '1234567891', '1234567891'),
(30, 'aaaa', '1234567891', '1234567891', '1234567891'),
(31, 'a', '1234657981', '1234657981', '1234657981'),
(32, 'a', '1234657981', '1234657981', '1234657981'),
(33, 'H', '1324567981', '1324567981', '1324567981'),
(34, 'Phương éo có cu', '1234567981', '1234567981', '1234567981'),
(35, 'Nguyễn Văn A', '0901010101', '1234567891', 'Tp.HCM'),
(36, 'Nguyễn Văn B', '0902020202', '1324567981', 'Việt Nam');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `Name` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Bed` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Vip` tinyint(1) NOT NULL,
  `Booked` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `room`
--

INSERT INTO `room` (`id`, `Name`, `Bed`, `Price`, `Vip`, `Booked`) VALUES
(12, '101', 1, 100, 1, 0),
(13, '102', 2, 120, 0, 1),
(14, '103', 2, 120, 0, 0),
(15, '104', 2, 200, 1, 0),
(16, '105', 2, 150, 0, 0),
(17, '106', 3, 200, 0, 0),
(18, '201', 1, 100, 0, 0),
(19, '202', 2, 150, 0, 0),
(20, '203', 3, 200, 1, 0),
(21, '204', 4, 250, 0, 0),
(22, '205', 1, 200, 1, 0),
(23, '206', 3, 250, 1, 0),
(24, '301', 1, 150, 0, 1),
(25, '302', 2, 200, 0, 0),
(26, '303', 1, 200, 1, 0),
(27, '304', 2, 180, 0, 0),
(28, '305', 4, 300, 1, 0),
(29, '306', 5, 300, 0, 0),
(32, '9999', 9999, 9999, 0, 1),
(33, '888132', 88, 888, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `service`
--

CREATE TABLE `service` (
  `id` int(11) NOT NULL,
  `Name` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `service`
--

INSERT INTO `service` (`id`, `Name`, `Description`, `Price`) VALUES
(7, 'Spa', 'Giúp khách thư giản', 200),
(8, 'Giặt ủi', 'Giặt ủi quần áo của khách', 50),
(9, 'Ăn sáng', 'Ắn sáng', 30),
(11, 'Aa', 'aaaa', 55);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `Username` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sdt` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Cmnd` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Address` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Position` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Manager` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`id`, `Username`, `Password`, `Name`, `Sdt`, `Cmnd`, `Address`, `Position`, `Manager`) VALUES
(12, 'admin', '123', 'Admin', '0969696969', '696969696969', 'Tp.HCM', 'Giám đốc', 1),
(18, 'vanhien', 'vanhien2001', 'Nguyễn Văn Hiền', '0936642182', '12345678910', 'Quảng Nam', 'Ngồi chơi', 1),
(19, 'khangvippro', '123', 'Phùng Duy Khang', '0793607376', '12345678910', 'Đắk Lắk', 'Rửa chén', 1),
(20, 'phuongvippro', '123', 'Nguyễn Thái Phương', '0962711960', '12345678910', 'Vũng Tàu', 'Tiếp khách', 1),
(21, 'topvipboy', '123', 'Huỳnh Lâm Khánh Duy', '0969369543', '12345678910', 'Tp.HCM', 'Giữ xe', 1),
(25, 'a', 'a', 'aaaa', '1234657981', '1234567981', 'aaaa', 'test', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `use_service`
--

CREATE TABLE `use_service` (
  `id` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_service` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `use_service`
--

INSERT INTO `use_service` (`id`, `id_customer`, `id_service`, `Date`) VALUES
(15, 20, 7, '2021-05-09 08:46:41'),
(17, 21, 8, '2021-05-09 09:38:43'),
(19, 22, 7, '2021-05-09 09:48:28'),
(22, 22, 7, '2021-05-11 14:10:19'),
(29, 24, 7, '2021-05-11 14:50:55'),
(31, 27, 7, '2021-05-11 15:04:07'),
(39, 35, 9, '2021-05-16 14:04:10'),
(40, 35, 8, '2021-05-16 14:04:13'),
(41, 35, 11, '2021-05-16 14:04:18'),
(42, 36, 7, '2021-05-16 14:04:47'),
(43, 36, 11, '2021-05-16 14:04:51');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_booking` (`id_booking`),
  ADD KEY `id_staff` (`id_staff`);

--
-- Chỉ mục cho bảng `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_room` (`id_room`),
  ADD KEY `id_customer` (`id_customer`),
  ADD KEY `id_staff` (`id_staff`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `use_service`
--
ALTER TABLE `use_service`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_customer` (`id_customer`),
  ADD KEY `id_service` (`id_service`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT cho bảng `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT cho bảng `service`
--
ALTER TABLE `service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT cho bảng `use_service`
--
ALTER TABLE `use_service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`id_booking`) REFERENCES `booking` (`id`),
  ADD CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id`);

--
-- Các ràng buộc cho bảng `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`id_room`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id`),
  ADD CONSTRAINT `booking_ibfk_4` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id`),
  ADD CONSTRAINT `booking_ibfk_5` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `booking_ibfk_6` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id`);

--
-- Các ràng buộc cho bảng `use_service`
--
ALTER TABLE `use_service`
  ADD CONSTRAINT `use_service_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `use_service_ibfk_2` FOREIGN KEY (`id_service`) REFERENCES `service` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
