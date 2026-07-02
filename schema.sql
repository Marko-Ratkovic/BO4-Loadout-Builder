-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2026 at 10:20 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bo4_loadouts`
--

-- --------------------------------------------------------

--
-- Table structure for table `attachments`
--

CREATE TABLE `attachments` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `pick_10_cost` int(11) DEFAULT 1,
  `image_url` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `pick_10_cost` int(11) DEFAULT 1,
  `unlock_level` int(11) DEFAULT 1,
  `image_url` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `gear`
--

CREATE TABLE `gear` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `pick_10_cost` int(11) DEFAULT 1,
  `unlock_level` int(11) DEFAULT 1,
  `image_url` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loadouts`
--

CREATE TABLE `loadouts` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `primary_weapon_id` int(11) DEFAULT NULL,
  `primary_optic_id` int(11) DEFAULT NULL,
  `primary_attachment_1` int(11) DEFAULT NULL,
  `primary_attachment_2` int(11) DEFAULT NULL,
  `primary_attachment_3` int(11) DEFAULT NULL,
  `primary_attachment_4` int(11) DEFAULT NULL,
  `primary_attachment_5` int(11) DEFAULT NULL,
  `secondary_weapon_id` int(11) DEFAULT NULL,
  `secondary_optic_id` int(11) DEFAULT NULL,
  `secondary_attachment_1` int(11) DEFAULT NULL,
  `secondary_attachment_2` int(11) DEFAULT NULL,
  `secondary_attachment_3` int(11) DEFAULT NULL,
  `secondary_attachment_4` int(11) DEFAULT NULL,
  `secondary_attachment_5` int(11) DEFAULT NULL,
  `perk_1_slot_1` int(11) DEFAULT NULL,
  `perk_1_slot_2` int(11) DEFAULT NULL,
  `perk_2_slot_1` int(11) DEFAULT NULL,
  `perk_2_slot_2` int(11) DEFAULT NULL,
  `perk_3_slot_1` int(11) DEFAULT NULL,
  `perk_3_slot_2` int(11) DEFAULT NULL,
  `gear_id` int(11) DEFAULT NULL,
  `equipment_id` int(11) DEFAULT NULL,
  `wildcard_1_id` int(11) DEFAULT NULL,
  `wildcard_2_id` int(11) DEFAULT NULL,
  `wildcard_3_id` int(11) DEFAULT NULL,
  `pick_10_total` int(11) DEFAULT 10,
  `is_public` tinyint(1) DEFAULT 1,
  `is_featured` tinyint(1) DEFAULT 0,
  `view_count` int(11) DEFAULT 0,
  `like_count` int(11) DEFAULT 0,
  `share_code` varchar(20) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loadout_comments`
--

CREATE TABLE `loadout_comments` (
  `id` int(11) NOT NULL,
  `loadout_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `comment` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loadout_likes`
--

CREATE TABLE `loadout_likes` (
  `user_id` int(11) NOT NULL,
  `loadout_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `optics`
--

CREATE TABLE `optics` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `zoom_level` varchar(20) DEFAULT NULL,
  `pick_10_cost` int(11) DEFAULT 1,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `perks`
--

CREATE TABLE `perks` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `tier` int(11) NOT NULL,
  `description` text NOT NULL,
  `pick_10_cost` int(11) DEFAULT 1,
  `unlock_level` int(11) DEFAULT 1,
  `image_url` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password_hash` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_login` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `weapons`
--

CREATE TABLE `weapons` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `category_id` int(11) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `damage_close` int(11) NOT NULL,
  `damage_medium` int(11) NOT NULL,
  `damage_medium2` int(11) DEFAULT NULL,
  `damage_medium3` int(11) DEFAULT NULL,
  `damage_far` int(11) NOT NULL,
  `headshot_damage_close` int(11) DEFAULT NULL,
  `headshot_damage_medium` int(11) DEFAULT NULL,
  `headshot_damage_medium2` int(11) DEFAULT NULL,
  `headshot_damage_medium3` int(11) DEFAULT NULL,
  `headshot_damage_far` int(11) DEFAULT NULL,
  `headshot_multiplier` decimal(3,2) DEFAULT 1.00,
  `upper_body_multiplier` decimal(3,2) DEFAULT 1.00,
  `lower_body_multiplier` decimal(3,2) DEFAULT 1.00,
  `limb_multiplier` decimal(3,2) DEFAULT 1.00,
  `stk_close` int(11) DEFAULT NULL,
  `stk_medium` int(11) DEFAULT NULL,
  `stk_medium2` int(11) DEFAULT NULL,
  `stk_medium3` int(11) DEFAULT NULL,
  `stk_far` int(11) DEFAULT NULL,
  `stk_close_headshot` int(11) DEFAULT NULL,
  `stk_medium_headshot` int(11) DEFAULT NULL,
  `stk_medium_headshot2` int(11) DEFAULT NULL,
  `stk_medium_headshot3` int(11) DEFAULT NULL,
  `stk_far_headshot` int(11) DEFAULT NULL,
  `ttk_close` varchar(20) DEFAULT NULL,
  `ttk_medium` varchar(20) DEFAULT NULL,
  `ttk_medium2` varchar(20) DEFAULT NULL,
  `ttk_medium3` varchar(20) DEFAULT NULL,
  `ttk_far` varchar(20) DEFAULT NULL,
  `ttk_close_headshot` varchar(20) DEFAULT NULL,
  `ttk_medium_headshot` varchar(20) DEFAULT NULL,
  `ttk_medium_headshot2` varchar(20) DEFAULT NULL,
  `ttk_medium_headshot3` varchar(20) DEFAULT NULL,
  `ttk_far_headshot` varchar(20) DEFAULT NULL,
  `fire_rate` varchar(20) NOT NULL,
  `magazine_size` int(11) NOT NULL,
  `range_close` varchar(20) DEFAULT NULL,
  `range_medium` varchar(20) DEFAULT NULL,
  `range_medium2` varchar(20) DEFAULT NULL,
  `range_medium3` varchar(20) DEFAULT NULL,
  `range_far` varchar(20) DEFAULT NULL,
  `movement` varchar(20) DEFAULT NULL,
  `ads_strafe` varchar(20) DEFAULT NULL,
  `ads_time` varchar(20) DEFAULT NULL,
  `sprint_out_time` varchar(20) DEFAULT NULL,
  `reload_time` varchar(20) DEFAULT NULL,
  `pick_10_cost` int(11) DEFAULT 1,
  `unlock_level` int(11) DEFAULT 1,
  `is_dlc` tinyint(1) DEFAULT 0,
  `description` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `weapon_attachments`
--

CREATE TABLE `weapon_attachments` (
  `weapon_id` int(11) NOT NULL,
  `attachment_id` int(11) NOT NULL,
  `weapon_level_unlock` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `weapon_categories`
--

CREATE TABLE `weapon_categories` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `display_order` int(11) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `weapon_optics`
--

CREATE TABLE `weapon_optics` (
  `weapon_id` int(11) NOT NULL,
  `optic_id` int(11) NOT NULL,
  `weapon_level_unlock` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `wildcards`
--

CREATE TABLE `wildcards` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `pick_10_cost` int(11) DEFAULT 1,
  `unlock_level` int(11) DEFAULT 1,
  `image_url` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attachments`
--
ALTER TABLE `attachments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gear`
--
ALTER TABLE `gear`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loadouts`
--
ALTER TABLE `loadouts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `share_code` (`share_code`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `primary_weapon_id` (`primary_weapon_id`),
  ADD KEY `primary_optic_id` (`primary_optic_id`),
  ADD KEY `primary_attachment_1` (`primary_attachment_1`),
  ADD KEY `primary_attachment_2` (`primary_attachment_2`),
  ADD KEY `primary_attachment_3` (`primary_attachment_3`),
  ADD KEY `primary_attachment_4` (`primary_attachment_4`),
  ADD KEY `primary_attachment_5` (`primary_attachment_5`),
  ADD KEY `secondary_weapon_id` (`secondary_weapon_id`),
  ADD KEY `secondary_optic_id` (`secondary_optic_id`),
  ADD KEY `secondary_attachment_1` (`secondary_attachment_1`),
  ADD KEY `secondary_attachment_2` (`secondary_attachment_2`),
  ADD KEY `secondary_attachment_3` (`secondary_attachment_3`),
  ADD KEY `secondary_attachment_4` (`secondary_attachment_4`),
  ADD KEY `secondary_attachment_5` (`secondary_attachment_5`),
  ADD KEY `perk_1_slot_1` (`perk_1_slot_1`),
  ADD KEY `perk_1_slot_2` (`perk_1_slot_2`),
  ADD KEY `perk_2_slot_1` (`perk_2_slot_1`),
  ADD KEY `perk_2_slot_2` (`perk_2_slot_2`),
  ADD KEY `perk_3_slot_1` (`perk_3_slot_1`),
  ADD KEY `perk_3_slot_2` (`perk_3_slot_2`),
  ADD KEY `gear_id` (`gear_id`),
  ADD KEY `equipment_id` (`equipment_id`),
  ADD KEY `wildcard_1_id` (`wildcard_1_id`),
  ADD KEY `wildcard_2_id` (`wildcard_2_id`),
  ADD KEY `wildcard_3_id` (`wildcard_3_id`),
  ADD KEY `idx_public` (`is_public`),
  ADD KEY `idx_featured` (`is_featured`);

--
-- Indexes for table `loadout_comments`
--
ALTER TABLE `loadout_comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `loadout_id` (`loadout_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `loadout_likes`
--
ALTER TABLE `loadout_likes`
  ADD PRIMARY KEY (`user_id`,`loadout_id`),
  ADD KEY `loadout_id` (`loadout_id`);

--
-- Indexes for table `optics`
--
ALTER TABLE `optics`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `perks`
--
ALTER TABLE `perks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `idx_username` (`username`);

--
-- Indexes for table `weapons`
--
ALTER TABLE `weapons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_category` (`category_id`);

--
-- Indexes for table `weapon_attachments`
--
ALTER TABLE `weapon_attachments`
  ADD PRIMARY KEY (`weapon_id`,`attachment_id`),
  ADD KEY `attachment_id` (`attachment_id`);

--
-- Indexes for table `weapon_categories`
--
ALTER TABLE `weapon_categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `weapon_optics`
--
ALTER TABLE `weapon_optics`
  ADD PRIMARY KEY (`weapon_id`,`optic_id`),
  ADD KEY `optic_id` (`optic_id`);

--
-- Indexes for table `wildcards`
--
ALTER TABLE `wildcards`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attachments`
--
ALTER TABLE `attachments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `equipment`
--
ALTER TABLE `equipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `gear`
--
ALTER TABLE `gear`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loadouts`
--
ALTER TABLE `loadouts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loadout_comments`
--
ALTER TABLE `loadout_comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `optics`
--
ALTER TABLE `optics`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `perks`
--
ALTER TABLE `perks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `weapons`
--
ALTER TABLE `weapons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `weapon_categories`
--
ALTER TABLE `weapon_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `wildcards`
--
ALTER TABLE `wildcards`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `loadouts`
--
ALTER TABLE `loadouts`
  ADD CONSTRAINT `loadouts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `loadouts_ibfk_10` FOREIGN KEY (`secondary_optic_id`) REFERENCES `optics` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_11` FOREIGN KEY (`secondary_attachment_1`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_12` FOREIGN KEY (`secondary_attachment_2`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_13` FOREIGN KEY (`secondary_attachment_3`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_14` FOREIGN KEY (`secondary_attachment_4`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_15` FOREIGN KEY (`secondary_attachment_5`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_16` FOREIGN KEY (`perk_1_slot_1`) REFERENCES `perks` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_17` FOREIGN KEY (`perk_1_slot_2`) REFERENCES `perks` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_18` FOREIGN KEY (`perk_2_slot_1`) REFERENCES `perks` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_19` FOREIGN KEY (`perk_2_slot_2`) REFERENCES `perks` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_2` FOREIGN KEY (`primary_weapon_id`) REFERENCES `weapons` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_20` FOREIGN KEY (`perk_3_slot_1`) REFERENCES `perks` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_21` FOREIGN KEY (`perk_3_slot_2`) REFERENCES `perks` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_22` FOREIGN KEY (`gear_id`) REFERENCES `gear` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_23` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_24` FOREIGN KEY (`wildcard_1_id`) REFERENCES `wildcards` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_25` FOREIGN KEY (`wildcard_2_id`) REFERENCES `wildcards` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_26` FOREIGN KEY (`wildcard_3_id`) REFERENCES `wildcards` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_3` FOREIGN KEY (`primary_optic_id`) REFERENCES `optics` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_4` FOREIGN KEY (`primary_attachment_1`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_5` FOREIGN KEY (`primary_attachment_2`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_6` FOREIGN KEY (`primary_attachment_3`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_7` FOREIGN KEY (`primary_attachment_4`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_8` FOREIGN KEY (`primary_attachment_5`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `loadouts_ibfk_9` FOREIGN KEY (`secondary_weapon_id`) REFERENCES `weapons` (`id`);

--
-- Constraints for table `loadout_comments`
--
ALTER TABLE `loadout_comments`
  ADD CONSTRAINT `loadout_comments_ibfk_1` FOREIGN KEY (`loadout_id`) REFERENCES `loadouts` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `loadout_comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL;

--
-- Constraints for table `loadout_likes`
--
ALTER TABLE `loadout_likes`
  ADD CONSTRAINT `loadout_likes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `loadout_likes_ibfk_2` FOREIGN KEY (`loadout_id`) REFERENCES `loadouts` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `weapons`
--
ALTER TABLE `weapons`
  ADD CONSTRAINT `weapons_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `weapon_categories` (`id`);

--
-- Constraints for table `weapon_attachments`
--
ALTER TABLE `weapon_attachments`
  ADD CONSTRAINT `weapon_attachments_ibfk_1` FOREIGN KEY (`weapon_id`) REFERENCES `weapons` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `weapon_attachments_ibfk_2` FOREIGN KEY (`attachment_id`) REFERENCES `attachments` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `weapon_optics`
--
ALTER TABLE `weapon_optics`
  ADD CONSTRAINT `weapon_optics_ibfk_1` FOREIGN KEY (`weapon_id`) REFERENCES `weapons` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `weapon_optics_ibfk_2` FOREIGN KEY (`optic_id`) REFERENCES `optics` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
