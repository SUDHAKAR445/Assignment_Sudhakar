create database Sports_DB;

use Sports_DB;

create table season (
	seasonId int primary key auto_increment,
    year int,
    startDate date,
    enddate date
);
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

alter table league add constraint FK_season_id foreign key (season) references season(seasonid); 

alter table team add seasonId int;

alter table team add constraint team_season_id foreign key (seasonId) references season(seasonid); 

alter table player add teamId int;

alter table player add constraint FK_Oteam_id foreign key (teamId) references team(teamid); 

alter table matches add seasonId int;

alter table matches add constraint matches_season_id foreign key (seasonId) references season(seasonid); 
