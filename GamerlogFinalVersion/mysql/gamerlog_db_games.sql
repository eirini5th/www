-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gamerlog_db
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `ID` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `yearReleased` int(11) DEFAULT NULL,
  `developers` varchar(255) DEFAULT NULL,
  `publishers` varchar(255) DEFAULT NULL,
  `genres` varchar(255) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,'Bioshock Infinite',2013,'Irrational Games','2K Games','First-person shooter','https://upload.wikimedia.org/wikipedia/el/d/d6/Bioshock_Infinite.jpg'),(2,'Bioshock',2007,'2K Boston, 2K Australia','2K Games','First-person shooter','https://upload.wikimedia.org/wikipedia/en/6/6d/BioShock_cover.jpg'),(3,'The Witcher 3: Wild Hunt',2015,'CD Projekt Red','CD Projekt','Action role-playing','https://upload.wikimedia.org/wikipedia/en/0/0c/Witcher_3_cover_art.jpg'),(4,'Grand Theft Auto V',2013,'Rockstar North','Rockstar Games','Action-adventure','https://upload.wikimedia.org/wikipedia/en/a/a5/Grand_Theft_Auto_V.png'),(5,'Horizon Zero Dawn',2017,'Guerilla Games','Sony Interactive Entertainment','Action role-playing','https://upload.wikimedia.org/wikipedia/en/9/93/Horizon_Zero_Dawn.jpg'),(6,'The Last of Us',2013,'Naughty Dog','Sony Computer Entertainment','Action-adventure, survival horror','https://upload.wikimedia.org/wikipedia/en/4/46/Video_Game_Cover_-_The_Last_of_Us.jpg'),(7,'Red Dead Redemption 2',2018,'Rockstar Studios','Rockstar Games','Action-adventure','https://upload.wikimedia.org/wikipedia/en/4/44/Red_Dead_Redemption_II.jpg'),(8,'Assasin\'s Creed Odyssey',2018,'Ubisoft Quebec','Ubisoft','Action role-playing','https://upload.wikimedia.org/wikipedia/en/9/99/ACOdysseyCoverArt.png'),(9,'Assasin\'s Creed: Brotherhood',2010,'Ubisoft Montreal','Ubisoft','Action-adventure, stealth','https://upload.wikimedia.org/wikipedia/en/2/2a/Assassins_Creed_brotherhood_cover.jpg'),(10,'Fallout 4',2015,'Bethesda Game Studios','Bethesda Softworks','Action role-playing','https://upload.wikimedia.org/wikipedia/en/7/70/Fallout_4_cover_art.jpg'),(11,'Half-Life 2',2004,'Valve','Valve','First-person shooter','https://upload.wikimedia.org/wikipedia/en/2/25/Half-Life_2_cover.jpg'),(12,'Life is Strange',2015,'Dontnod Entertainment','Square Enix','Graphic adventure','https://upload.wikimedia.org/wikipedia/en/9/9e/Life_Is_Strange_cover.jpg'),(13,'Sherlock Holmes: Crimes & Punishments',2014,'Frogwares','Frogwares','Adventure','https://upload.wikimedia.org/wikipedia/en/8/85/Sherlock_Holmes_Crimes_and_Punishments.jpg'),(14,'Portal 2',2011,'Valve','Valve','Puzzle-platform','https://upload.wikimedia.org/wikipedia/en/f/f9/Portal2cover.jpg'),(15,'Assassin\'s Creed II',2009,'Ubisoft Montreal','Ubisoft','Action-adventure, stealth','https://upload.wikimedia.org/wikipedia/en/7/77/Assassins_Creed_2_Box_Art.JPG'),(16,'Dishonored',2012,'Arkane Studios','Bethesda Softworks','Action-adventure, stealth','https://upload.wikimedia.org/wikipedia/en/6/65/Dishonored_box_art_Bethesda.jpg'),(17,'Prey',2017,'Arkane Studios','Bethesda Softworks','First-person shooter','https://upload.wikimedia.org/wikipedia/en/2/29/Prey_cover_art.jpg'),(18,'Nier: Automata',2017,'PlatinumGames','Square Enix','Action role-playing','https://upload.wikimedia.org/wikipedia/en/2/21/Nier_Automata_cover_art.jpg'),(19,'Beyond: Two Souls',2013,'Quantic Dream','Sony Computer Entertainment, Quantic Dream','Interactive drama, action-adventure','https://upload.wikimedia.org/wikipedia/en/d/da/Beyond_Two_Souls_final_cover.jpg'),(20,'Detroit: Become Human',2018,'Quantic Dream','Sony Computer Entertainment, Quantic Dream','Adventure','https://upload.wikimedia.org/wikipedia/en/e/ee/Detroit_Become_Human.jpg'),(21,'Fallout: New Vegas',2010,'Obsidian Entertainment','Bethesda Softworks','Action role-playing','https://upload.wikimedia.org/wikipedia/en/3/34/Fallout_New_Vegas.jpg'),(22,'Uncharted: Drake\'s Fortune',2007,'Naughty Dog','Sony Computer Entertainment','Action-adventure, third-person shooter, platformer','https://upload.wikimedia.org/wikipedia/en/5/5b/Uncharted_Drake%27s_Fortune.jpg'),(23,'Uncharted 2: Among Thieves',2009,'Naughty Dog','Sony Computer Entertainment','Action-adventure, platformer, third-person shooter','https://upload.wikimedia.org/wikipedia/en/7/7b/Uncharted_2_box_artwork.jpg'),(24,'Uncharted 3: Drake\'s Deception',2011,'Naughty Dog','Sony Computer Entertainment','Action-adventure, third-person shooter, platformer','https://upload.wikimedia.org/wikipedia/en/0/02/Uncharted_3_Boxart.jpg'),(25,'Uncharted 4: A Thief\'s End',2016,'Naughty Dog','Sony Computer Entertainment','Action-adventure, third-person shooter, platformer','https://upload.wikimedia.org/wikipedia/en/1/1a/Uncharted_4_box_artwork.jpg'),(26,'BioShock 2',2010,'2K Marin','2K Games','First-person shooter','https://upload.wikimedia.org/wikipedia/en/8/8c/Bioshock2_cover.png'),(27,'BioShock Infinite: Burial at Sea',2013,'Irrational Games','2K Games','First-person shooter, stealth','https://upload.wikimedia.org/wikipedia/en/5/50/BioShock_Burial_at_Sea.jpg'),(28,'BioShock 2: Minerva\'s Den',2010,'2K Marin','2K Games','First-person shooter','https://upload.wikimedia.org/wikipedia/en/thumb/5/5b/Minerva%27s_Den%2C_Title_Screen.png/330px-Minerva%27s_Den%2C_Title_Screen.png'),(29,'Grand Theft Auto: San Andreas',2004,'Rockstar North','Rockstar Games','Action-adventure','https://upload.wikimedia.org/wikipedia/en/c/c4/GTASABOX.jpg'),(30,'Grand Theft Auto IV',2008,'Rockstar North','Rockstar Games','Action-adventure','https://upload.wikimedia.org/wikipedia/en/b/b7/Grand_Theft_Auto_IV_cover.jpg'),(31,'L.A. Noire',2011,'Team Bondi','Rockstar Games','Action-adventure','https://upload.wikimedia.org/wikipedia/en/3/3c/LA-Noire-Box-Art.jpg'),(32,'The Elder Scrolls IV: Oblivion',2006,'Bethesda Game Studios','Bethesda Softworks','Action role-playing','https://upload.wikimedia.org/wikipedia/en/4/4b/The_Elder_Scrolls_IV_Oblivion_cover.png'),(33,'The Elder Scrolls V: Skyrim',2011,'Bethesda Game Studios','Bethesda Softworks','Action role-playing','https://upload.wikimedia.org/wikipedia/en/1/15/The_Elder_Scrolls_V_Skyrim_cover.png');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-15  1:33:18
