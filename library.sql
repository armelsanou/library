-- phpMyAdmin SQL Dump
-- version 4.9.7deb1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : jeu. 27 jan. 2022 à 17:02
-- Version du serveur :  10.5.13-MariaDB-0ubuntu0.21.04.1
-- Version de PHP : 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `library`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonnement`
--

CREATE TABLE `abonnement` (
  `id_abonnement` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `periode` varchar(255) DEFAULT NULL,
  `prix` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `abonnement`
--

INSERT INTO `abonnement` (`id_abonnement`, `description`, `libelle`, `periode`, `prix`) VALUES
(1, 'Cette offre est valable pour\r\nune durée de 1 semaine...\r\nJuste ce qu\'il vous faut\r\npour vous permettre de profiter\r\ndu bonheur de nos bookins.', 'Découverte', '1', 1),
(2, 'Cette offre est valable pour\r\nune durée de 2 semaines...\r\nJuste ce qu\'il vous faut\r\npour vous permettre de profiter\r\ndu bonheur de nos bookins.', 'Fidélité', '2', 2),
(3, 'Cette offre est valable pour\r\nune durée de 4 semaines...\r\nJuste ce qu\'il vous faut pour,\r\nvous permettre de nager dans\r\nnotre vaste gamme de bookins.', 'Pour les habitués', '4', 4);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `libelle`, `image`) VALUES
(1, 'Categorie 22', 'hansel et gretel.jpg'),
(2, 'Categorie 1', 'Hp1.jpg'),
(3, 'physiquee', 'Hp2.jpg'),
(4, 'langue', 'Hp6.jpg'),
(5, 'astrologie', 'Hp7.jpg'),
(6, 'santé', 'la chambre des merveilles.jpg'),
(7, 'psychologie', 'anthologie negre.jpg'),
(8, 'Marketing', 'appart à paris.jpg'),
(9, 'Cuisine', 'cuisine africaines.jpg'),
(10, 'THINK OUT OF THE BOX', 'cuisiner avec thermomix.jpg'),
(11, 'informatique', 'le combat de melissa.jpg'),
(12, 'mathematique', 'blanche neig.jpg'),
(17, 'soniaa', 'blanche neig.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `effectuerabonnement`
--

CREATE TABLE `effectuerabonnement` (
  `date_debut_abonnement` date NOT NULL,
  `id_abonnement` int(11) NOT NULL,
  `id_lecteur` int(11) NOT NULL,
  `date_fin_abonnement` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `effectuerabonnement`
--

INSERT INTO `effectuerabonnement` (`date_debut_abonnement`, `id_abonnement`, `id_lecteur`, `date_fin_abonnement`) VALUES
('2021-12-01', 1, 4, '2021-12-07'),
('2021-12-24', 1, 2, '2021-12-31'),
('2021-12-24', 3, 2, '2022-01-21'),
('2021-12-25', 3, 3, '2022-01-22'),
('2022-01-04', 2, 3, '2022-01-18'),
('2022-01-07', 2, 6, '2022-01-21'),
('2022-01-23', 1, 2, '2022-01-30');

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `date_emprunt` date NOT NULL,
  `id_lecteur` int(11) NOT NULL,
  `isbn` int(11) NOT NULL,
  `date_retour_eff` date DEFAULT NULL,
  `date_retour_theo` date DEFAULT NULL,
  `nbr_avertissement` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`date_emprunt`, `id_lecteur`, `isbn`, `date_retour_eff`, `date_retour_theo`, `nbr_avertissement`) VALUES
('2021-12-01', 4, 1111, '2022-01-23', '2021-12-03', 3),
('2021-12-16', 2, 1111, '2022-01-07', '2021-12-14', 9),
('2022-01-05', 2, 3333, '2022-01-07', '2022-01-21', 9),
('2022-01-08', 6, 1013, NULL, '2022-01-21', 2),
('2022-01-08', 6, 8888, NULL, '2022-01-21', 0),
('2022-01-08', 6, 9999, NULL, '2022-01-21', 0),
('2022-01-23', 2, 1017, NULL, '2022-01-30', 0),
('2022-01-23', 2, 1018, NULL, '2022-01-30', 0);

-- --------------------------------------------------------

--
-- Structure de la table `etatlivre`
--

CREATE TABLE `etatlivre` (
  `id_etat_livre` int(11) NOT NULL,
  `etat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etatlivre`
--

INSERT INTO `etatlivre` (`id_etat_livre`, `etat`) VALUES
(1, 'Vieuxx'),
(2, 'Ancien'),
(4, 'Nouveaux');

-- --------------------------------------------------------

--
-- Structure de la table `lecteur`
--

CREATE TABLE `lecteur` (
  `id_lecteur` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `lecteur`
--

INSERT INTO `lecteur` (`id_lecteur`, `email`, `login`, `mdp`, `nom`, `prenom`, `role`, `telephone`, `image`) VALUES
(2, 'armel@sanou.com', 'armel', 'armel', 'sanou', 'sauvy', 'lecteur', '0758397157', 'profile.jpeg'),
(3, 'armel@sanou.com', 'armel', NULL, 'sanou', 'sauvyy', 'lecteur', '0758397157', 'profile.jpeg'),
(4, 'loic@sanou.com', 'loic', 'loic', 'loic', '', 'lecteur', '', 'profile.jpeg'),
(5, 'melo@melo.com', 'melo', 'melo', 'melo', 'melo', 'lecteur', '0758397157', 'profile.jpeg'),
(6, 'admin@admin.com', 'admin', 'admin', 'admin', 'administrateur', 'bibliothecaire', '0758397157', NULL),
(9, 'test@user.com', 'user', 'user', 'test user', 'i have and image', 'lecteur', '564312', NULL),
(10, 'dernier@test.com', 'test', 'test', 'test final', 'dernier test', 'lecteur', '5641', 'l-histoire-du-livre.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `isbn` int(11) NOT NULL,
  `auteur` varchar(255) DEFAULT NULL,
  `date_edition` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  `id_categorie` int(11) DEFAULT NULL,
  `id_etat_livre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`isbn`, `auteur`, `date_edition`, `description`, `image`, `titre`, `id_categorie`, `id_etat_livre`) VALUES
(1010, 'melo', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'afrika-baa.jpg', 'la terre tourneee', 3, 2),
(1011, 'melo', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'anthologie negre.jpg', 'les trous noirs', 3, 2),
(1012, 'armel sanouuuuuuuuuuuu', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'appart à paris.jpg', 'la mécanique des fluidessssssssssss', 3, 2),
(1013, 'armel sanou', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'atelier de roxane.jpg', 'physique quantique', 3, 2),
(1015, 'sanou armel', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'balafon.jpg', 'electrostatique', 3, 2),
(1016, 'sanou armel', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'blanche neig.jpg', 'Programmation avancée', 11, 2),
(1017, 'sanou armel', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'colonise.jpg', 'Clustering', 11, 2),
(1018, 'sanou armel', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'cuisine africaines.jpg', 'Co-Clustering', 11, 2),
(1019, 'sanou armel', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'cuisiner avec thermomix.jpg', 'Réduction de la dimension', 11, 2),
(1111, 'armel', NULL, 'description', 'dans l\'ombre de la clairière.jpg', 'titre', 1, 1),
(2020, 'sanou armel', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'ebene.jpg', 'Régression linéaire', 11, 2),
(2021, 'armel san', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'hansel et gretel.jpg', 'Régression linéaire multiple', 11, 2),
(2022, 'armel san', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'Hp1.jpg', 'Régression logistique', 11, 2),
(2023, 'armel san', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'Hp2.jpg', 'Machine a vecteur de supportte', 11, 2),
(2024, 'armel san', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'Hp6.jpg', 'optimisation combinatoire', 11, 2),
(2025, 'melat', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'Hp7.jpg', 'algorithmique et complexité', 11, 2),
(2222, 'loico square', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'la chambre des merveilles.jpg', 'Lorem livre', 11, 1),
(3333, 'melo', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'l-afrique-noire-precoloniale-.jpg', 'Lorem livre', 6, 4),
(5555, 'armel', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'la vague.jpg', 'LIvre math 2', 6, 2),
(6666, 'armel', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'le combat de melissa.jpg', 'LIvre math 3', 6, 2),
(7777, 'armel', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'le hobbit.jpg', 'Livre think 1', 10, 2),
(8888, 'Sanou', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'profile.jpeg', 'Livre think 2', 10, 2),
(9999, 'san', '2021-12-07', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, debitis ex quae explicabo consequuntur accusamus eos maiores quod rerum beatae reiciendis nulla officia numquam reprehenderit fuga blanditiis in amet odio.', 'que-signifie-format-de-poche.jpg', 'Livre think 333', 10, 2);

-- --------------------------------------------------------

--
-- Structure de la table `rayon`
--

CREATE TABLE `rayon` (
  `id_rayon` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `id_categorie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rayon`
--

INSERT INTO `rayon` (`id_rayon`, `libelle`, `id_categorie`) VALUES
(1, 'Rayon 1', 12),
(4, 'Rayon 11', 3),
(8, 'gvj', 11);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `abonnement`
--
ALTER TABLE `abonnement`
  ADD PRIMARY KEY (`id_abonnement`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Index pour la table `effectuerabonnement`
--
ALTER TABLE `effectuerabonnement`
  ADD PRIMARY KEY (`date_debut_abonnement`,`id_abonnement`,`id_lecteur`),
  ADD KEY `FKe36m2n54oqvqthhev01kysqgi` (`id_abonnement`),
  ADD KEY `FKen5ahg6ncx79rqtao78g9e194` (`id_lecteur`);

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`date_emprunt`,`id_lecteur`,`isbn`),
  ADD KEY `FK3c59xcfydvbei3l3d1wlo3lp7` (`id_lecteur`),
  ADD KEY `FKg0aq8oicnmg3ekkws6x3sy9ph` (`isbn`);

--
-- Index pour la table `etatlivre`
--
ALTER TABLE `etatlivre`
  ADD PRIMARY KEY (`id_etat_livre`);

--
-- Index pour la table `lecteur`
--
ALTER TABLE `lecteur`
  ADD PRIMARY KEY (`id_lecteur`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `FKprsufec2xor23a45wg7356i2i` (`id_categorie`),
  ADD KEY `FKbhyc40ipbaw1l23de0qv9djbe` (`id_etat_livre`);

--
-- Index pour la table `rayon`
--
ALTER TABLE `rayon`
  ADD PRIMARY KEY (`id_rayon`),
  ADD KEY `FKcv43c92qd2vl91nr8xl4pebsw` (`id_categorie`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `abonnement`
--
ALTER TABLE `abonnement`
  MODIFY `id_abonnement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `etatlivre`
--
ALTER TABLE `etatlivre`
  MODIFY `id_etat_livre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `lecteur`
--
ALTER TABLE `lecteur`
  MODIFY `id_lecteur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `rayon`
--
ALTER TABLE `rayon`
  MODIFY `id_rayon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `effectuerabonnement`
--
ALTER TABLE `effectuerabonnement`
  ADD CONSTRAINT `FKe36m2n54oqvqthhev01kysqgi` FOREIGN KEY (`id_abonnement`) REFERENCES `abonnement` (`id_abonnement`),
  ADD CONSTRAINT `FKen5ahg6ncx79rqtao78g9e194` FOREIGN KEY (`id_lecteur`) REFERENCES `lecteur` (`id_lecteur`);

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `FK3c59xcfydvbei3l3d1wlo3lp7` FOREIGN KEY (`id_lecteur`) REFERENCES `lecteur` (`id_lecteur`),
  ADD CONSTRAINT `FKg0aq8oicnmg3ekkws6x3sy9ph` FOREIGN KEY (`isbn`) REFERENCES `livre` (`isbn`);

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `FKbhyc40ipbaw1l23de0qv9djbe` FOREIGN KEY (`id_etat_livre`) REFERENCES `etatlivre` (`id_etat_livre`),
  ADD CONSTRAINT `FKprsufec2xor23a45wg7356i2i` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`);

--
-- Contraintes pour la table `rayon`
--
ALTER TABLE `rayon`
  ADD CONSTRAINT `FKcv43c92qd2vl91nr8xl4pebsw` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
