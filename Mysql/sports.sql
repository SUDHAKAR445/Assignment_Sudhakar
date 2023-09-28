create database Sports_DB;

use Sports_DB;


create table League(
	LeagueID int primary key auto_increment,
    LeagueName varchar(255),
    Season int
);

create table Team(
	TeamID int primary key auto_increment,
    TeamName varchar(255),
    Coach varchar(255),
    HomeCity varchar(255),
    LeagueID int,
    foreign key (LeagueID) references League(LeagueId)
);

create table Matches(
	MatchId int primary key auto_increment,
    Date date,
    Location varchar(255),
    LeagueID int,
    foreign key(LeagueID) references League(LeagueID)
);

create table Player(
	PlayerId int primary key auto_increment,
    FirstName varchar(255),
    LastName varchar(255),
    Position varchar(255),
    DateOfBirth date
);

create table MatchPlayer(
	MatchPlayerID int primary key auto_increment,
    JerseyNumber int,
    MatchID int,
    PlayerID int,
    foreign key(MatchID) references Matches(MatchID),
    foreign key(PlayerID) references Player(PlayerID)
);

create table MatchScore(
	MatchScoreID int primary key auto_increment,
    TeamScore int,
    OpponentScore int,
    MatchID int,
    foreign key(MatchID) references Matches(MatchID)
);

create table PlayerStatistics(
	PlayerStatisticsID int primary key auto_increment,
    GoalsScored int,
    Assists int,
    MinutesPlayed int,
    MatchID int,
    PlayerID int,
    foreign key(MatchID) references Matches(MatchID),
    foreign key(PlayerID) references Player(PlayerID)
);