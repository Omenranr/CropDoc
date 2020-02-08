-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 04 fév. 2020 à 23:48
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetjee`
--

-- --------------------------------------------------------

--
-- Structure de la table `disease`
--

CREATE TABLE `disease` (
  `name` varchar(250) NOT NULL,
  `levelOfDanger` varchar(250) DEFAULT NULL,
  `scienceName` varchar(250) DEFAULT NULL,
  `treatmentName` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `disease_parcelle`
--

CREATE TABLE `disease_parcelle` (
  `name` varchar(250) NOT NULL,
  `id_parcelle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `elevage`
--

CREATE TABLE `elevage` (
  `id_Elevage` int(11) NOT NULL,
  `type_Elevage` varchar(50) NOT NULL,
  `superficie` double NOT NULL,
  `headNumber` int(11) NOT NULL,
  `id_farm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `elevage`
--

INSERT INTO `elevage` (`id_Elevage`, `type_Elevage`, `superficie`, `headNumber`, `id_farm`) VALUES
(3, 'ship', 1000, 28, 1),
(4, 'goat', 1000, 100, 1),
(5, 'horse', 100, 400, 1);

-- --------------------------------------------------------

--
-- Structure de la table `farm`
--

CREATE TABLE `farm` (
  `id_farm` int(11) NOT NULL,
  `id_fermier` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `superficie_totale` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `farm`
--

INSERT INTO `farm` (`id_farm`, `id_fermier`, `city`, `superficie_totale`) VALUES
(1, 5, 'Rabat', 2000),
(2, 13, 'Agadir', 0);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id_message` int(11) NOT NULL,
  `type` varchar(250) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `date` date DEFAULT NULL,
  `id_farmer` int(11) DEFAULT NULL,
  `id_worker` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `id_notification` int(11) NOT NULL,
  `type` varchar(250) NOT NULL,
  `content` varchar(250) NOT NULL,
  `date` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_commun` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `parcelle`
--

CREATE TABLE `parcelle` (
  `id_parcelle` int(11) NOT NULL,
  `type_culture` varchar(50) NOT NULL,
  `superficie` double NOT NULL,
  `disease_Detected` tinyint(1) DEFAULT NULL,
  `scienceName` varchar(250) NOT NULL,
  `id_farm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `plant`
--

CREATE TABLE `plant` (
  `scienceName` varchar(250) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `variety` varchar(250) DEFAULT NULL,
  `nightTemp` double DEFAULT NULL,
  `dayTemp` double DEFAULT NULL,
  `criticalTempMax` double DEFAULT NULL,
  `criticalTempMin` double DEFAULT NULL,
  `numberMonths` int(11) DEFAULT NULL,
  `climatGeography` varchar(250) DEFAULT NULL,
  `insights` varchar(250) DEFAULT NULL,
  `picture` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `task`
--

CREATE TABLE `task` (
  `Id_task` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date DEFAULT NULL,
  `urgency` varchar(50) DEFAULT NULL,
  `accomplie` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `task_user`
--

CREATE TABLE `task_user` (
  `id_task` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `treatment`
--

CREATE TABLE `treatment` (
  `name` varchar(250) NOT NULL,
  `treatment` varchar(250) NOT NULL,
  `cause` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type_user` varchar(50) DEFAULT NULL,
  `id_farm` int(11) DEFAULT NULL,
  `Salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `email`, `password`, `type_user`, `id_farm`, `Salary`) VALUES
(1, NULL, NULL, 'mazid@gamil.com', '123', '', 0, 0),
(5, NULL, NULL, 'mazidsefiane@gmail.com', '123', '', 0, 0),
(6, NULL, NULL, 'try@gmail.com', 'jee', '', 0, 0),
(8, NULL, NULL, 'sd@dsd', '12345', '', 0, 0),
(9, NULL, NULL, 'vive.raja2010@live.fr', '1234', '', 0, 0),
(10, NULL, NULL, 'unknown@gmail.com', 'HUZGE45', '', 0, 0),
(11, NULL, NULL, 'ali@gmail.com', '123', '', 0, 0),
(12, NULL, NULL, 'oussama@gmail.com', '123', '', 0, 0),
(13, NULL, NULL, 'person@gmail.com', '123', '', 1, 0),
(18, NULL, NULL, 'person2@gmail.com', '123', '', 1, 0),
(19, NULL, NULL, 'person3@gmail.com', '123', '', 1, 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `disease`
--
ALTER TABLE `disease`
  ADD PRIMARY KEY (`name`);

--
-- Index pour la table `elevage`
--
ALTER TABLE `elevage`
  ADD PRIMARY KEY (`id_Elevage`);

--
-- Index pour la table `farm`
--
ALTER TABLE `farm`
  ADD PRIMARY KEY (`id_farm`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id_message`);

--
-- Index pour la table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id_notification`);

--
-- Index pour la table `parcelle`
--
ALTER TABLE `parcelle`
  ADD PRIMARY KEY (`id_parcelle`);

--
-- Index pour la table `plant`
--
ALTER TABLE `plant`
  ADD PRIMARY KEY (`scienceName`);

--
-- Index pour la table `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`name`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `elevage`
--
ALTER TABLE `elevage`
  MODIFY `id_Elevage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `farm`
--
ALTER TABLE `farm`
  MODIFY `id_farm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id_message` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `notification`
--
ALTER TABLE `notification`
  MODIFY `id_notification` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `parcelle`
--
ALTER TABLE `parcelle`
  MODIFY `id_parcelle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
