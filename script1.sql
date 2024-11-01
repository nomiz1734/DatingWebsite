CREATE DATABASE [DP]
GO
ALTER DATABASE [DP] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DP].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DP] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DP] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DP] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DP] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DP] SET ARITHABORT OFF 
GO
ALTER DATABASE [DP] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DP] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DP] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DP] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DP] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DP] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DP] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DP] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DP] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DP] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DP] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DP] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DP] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DP] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DP] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DP] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DP] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DP] SET RECOVERY FULL 
GO
ALTER DATABASE [DP] SET  MULTI_USER 
GO
ALTER DATABASE [DP] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DP] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DP] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DP] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DP] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DP] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'DP', N'ON'
GO
ALTER DATABASE [DP] SET QUERY_STORE = OFF
GO
USE [DP]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[block_user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_account_id] [int] NULL,
	[user_account_id_blocked] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
      
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[conversation_mes](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](255) NULL,
	[time_send] [time](7) NULL,
	[user_send] [varchar](64) NULL,
	[user_receive] [varchar](64) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[gender](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[gender_name] [varchar](32) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
insert into gender(gender_name) values ('Male')
insert into gender(gender_name) values ('Female')
insert into gender(gender_name) values ('Other')
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[like_user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](64) NULL,
	[username_liked] [varchar](64) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[match_user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_1] [varchar](64) NULL,
	[user_2] [varchar](64) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](64) NULL,
	[user_type_id] [int] NULL,
	[gender_id] [int] NULL,
	[email] [varchar](128) NOT NULL,
	[address] [varchar](250) NOT NULL,
	[password] [nvarchar](24) NULL,
	[avatar] [nvarchar](255) NULL,
	[full_name] [nvarchar](50) NULL,
	[detais] [nvarchar](255) NULL,
	[facebook] [nvarchar](255) NULL,
	[status] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ_user_account_username] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_type](
	[id] [int] IDENTITY(0,1) NOT NULL,
	[user_type_name] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
insert into user_type(user_type_name) values ('User')
insert into user_type(user_type_name) values ('Admin')
GO
ALTER TABLE [dbo].[block_user]  WITH CHECK ADD FOREIGN KEY([user_account_id])
REFERENCES [dbo].[user_account] ([id])
GO
ALTER TABLE [dbo].[block_user]  WITH CHECK ADD FOREIGN KEY([user_account_id_blocked])
REFERENCES [dbo].[user_account] ([id])
GO
ALTER TABLE [dbo].[like_user]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[user_account] ([username])
GO
ALTER TABLE [dbo].[match_user]  WITH CHECK ADD FOREIGN KEY([user_1])
REFERENCES [dbo].[user_account] ([username])
GO
ALTER TABLE [dbo].[user_account]  WITH CHECK ADD FOREIGN KEY([gender_id])
REFERENCES [dbo].[gender] ([id])
GO
ALTER TABLE [dbo].[user_account]  WITH CHECK ADD FOREIGN KEY([user_type_id])
REFERENCES [dbo].[user_type] ([id])
GO
ALTER DATABASE [DP] SET  READ_WRITE 
GO

INSERT INTO [dbo].[user_account]([username],[user_type_id],[gender_id],[email],[address],[password],[avatar],[full_name],[detais],[facebook],[status])
     VALUES ('nomiz1',1,1,'nomizsaplayvo@gmail.com','da nang cuty','Nomiz@1734',null,'Chu Minh Giang','admin',null,null)
INSERT INTO [dbo].[user_account]([username],[user_type_id],[gender_id],[email],[address],[password],[avatar],[full_name],[detais],[facebook],[status])
     VALUES ('yang1',0,1,'tnguoinaodo.laai@gmail.com','da nang cuty','Nomiz@1734',null,'Chu Minh Giang','admin',null,null)
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('dpinare0', 0, 3, 'dpinare0@mozilla.org', '38025 Merry Court', 'dA1`~(*S=`/', 'PG', 'Don Pinare', 'PK', 'BR', 'AU');
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('baveries1', 0, 1, 'baveries1@pcworld.com', '7 Colorado Crossing', 'hM9?R+X~}', 'PH', 'Birdie Averies', 'US', 'CA', 'IN');
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('gmassot2', 0, 3, 'gmassot2@github.com', '175 Crest Line Drive', 'tU4"F''}Xy7"EL>!)', 'BO', 'Guilbert Massot', 'ID', 'US', 'BE');
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('acarnock3', 0, 1, 'acarnock3@slashdot.org', '4435 2nd Avenue', 'fP5''tU)MefG~', 'US', 'Alene Carnock', 'CN', 'US', 'SD');
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('jgreger4', 0, 1, 'jgreger4@bigcartel.com', '0935 Ridgeview Drive', 'mS5''#gZCFs<h', 'KE', 'Jo-anne Greger', 'US', 'BW', 'ID');
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('igissing5', 0, 2, 'igissing5@nasa.gov', '3892 Gina Crossing', 'zQ7&h,!{MV`Z', 'US', 'Inglebert Gissing', 'RU', 'JP', 'FR');
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('akarolczyk6', 0, 2, 'akarolczyk6@deliciousdays.com', '063 Service Trail', 'xE4}Y9!5M@I', 'MG', 'Alwin Karolczyk', 'PG', 'EG', 'US');
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('emurrigans7', 0, 3, 'emurrigans7@tmall.com', '206 Debs Crossing', 'tK9`d<!/O(sR', 'CN', 'Enid Murrigans', 'VE', 'RU', 'CN');
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('fmenico8', 0, 2, 'fmenico8@github.com', '42113 Crownhardt Trail', 'xC2@fudQbD"<*86o', 'JP', 'Fabio Menico', 'CA', 'ZA', 'GY');
insert into user_account (username, user_type_id, gender_id, email, address, password, avatar, full_name, detais, facebook, status) values ('erankmore9', 0, 3, 'erankmore9@altervista.org', '453 Gulseth Parkway', 'yM8%e''Zi?0t9Z', 'CF', 'Elizabet Rankmore', 'TH', 'IN', 'AU');
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[report](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](64) NULL,
	[username_reported] [varchar](64) NULL,
	[reason] [varchar](64) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER TABLE [dbo].[report]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[user_account] ([username])
GO