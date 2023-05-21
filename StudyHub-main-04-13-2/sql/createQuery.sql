
create database StudyHub
go
use  StudyHub
CREATE TABLE [dbo].[User](
	[id_user] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY ,
	[name] [nvarchar](20)  NOT NULL,
	[email] [nvarchar](30)  NULL,
	[passwort] [nvarchar](20)  NOT NULL,
	[averageMark] [float] NULL,
)

---------------------------------------

CREATE TABLE [dbo].[Word](
	[id_word] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY ,

	[name] [nvarchar](25)  NOT NULL,
	[meaning] [nvarchar](100)  NOT NULL,
	[translation] [nvarchar](100) NOT NULL,
	[picture] [varbinary](MAX) NULL,
	[extension] [varchar](20) NULL,
)
---------------------------------------

CREATE TABLE [dbo].[Task](
	[id_task] [int]  IDENTITY(1,1) NOT NULL PRIMARY KEY ,
	[task_content] [nvarchar](500)  NULL,
	[answer] [nvarchar](50) NULL,
	[complexity_level] [nvarchar](2) NULL,
	[fk_kind] int NOT NULL,
)
------------------------------
CREATE TABLE [dbo].[KindOfTask](
	[id_kot] [int] IDENTITY(1,1)  NOT NULL PRIMARY KEY ,
	[name] [nvarchar](20)  NULL,
)
------------------------------
CREATE TABLE [dbo].[TaskList](
	[id_task] [int]  IDENTITY(1,1) NOT NULL PRIMARY KEY ,
	[fk_task] int NOT NULL,
	[fk_user] int NOT NULL,
	[fk_usersAnswer] int NOT NULL,
	[content] [nvarchar](20) NULL,
	[mark] int NULL,
)
------------------------------
CREATE TABLE [dbo].[Text](
	[id_text] [int] IDENTITY(1,1)  NOT NULL PRIMARY KEY ,
	[content] [nvarchar](max) NULL,
	[name] [nvarchar](50) NULL,
	[complexity_level] [nvarchar](2) NOT NULL,
	[fk_admin] [int] NOT NULL,
)
------------------------------
CREATE TABLE [dbo].[PersonalDictionary](
	[id_pd] [int] IDENTITY(1,1)  NOT NULL PRIMARY KEY ,
	[fk_word] int NOT NULL,
	[fk_user] int NOT NULL,
)
------------------------------
CREATE TABLE [dbo].[Texts](
	[id_texts] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY ,
	[fk_text] int NOT NULL,
	[fk_user] int NOT NULL,
)
------------------------------
CREATE TABLE [dbo].[Admin](
	[id_admin] [int]  IDENTITY(1,1) NOT NULL PRIMARY KEY ,
	[name] [nvarchar](20)  NOT NULL,
	[email] [nvarchar](30)  NULL,
	[passwort] [nvarchar](20)  NOT NULL,
)
------------------------------
ALTER TABLE [dbo].[PersonalDictionary]  WITH CHECK ADD  CONSTRAINT [FK_PersonalDictionary_Word] FOREIGN KEY([fk_word])
REFERENCES [dbo].[Word] ([id_word])
ALTER TABLE [dbo].[PersonalDictionary] CHECK CONSTRAINT [FK_PersonalDictionary_Word]

ALTER TABLE [dbo].[PersonalDictionary]  WITH CHECK ADD  CONSTRAINT [FK_PersonalDictionary_User] FOREIGN KEY([fk_user])
REFERENCES [dbo].[User] ([id_user])
ALTER TABLE [dbo].[PersonalDictionary] CHECK CONSTRAINT [FK_PersonalDictionary_User]

ALTER TABLE [dbo].[TaskList]  WITH CHECK ADD  CONSTRAINT [FK_TaskList_User] FOREIGN KEY([fk_user])
REFERENCES [dbo].[User] ([id_user])
ALTER TABLE [dbo].[TaskList] CHECK CONSTRAINT [FK_TaskList_User]

ALTER TABLE [dbo].[Texts]  WITH CHECK ADD  CONSTRAINT [FK_Texts_User] FOREIGN KEY([fk_user])
REFERENCES [dbo].[User] ([id_user])
ALTER TABLE [dbo].[Texts] CHECK CONSTRAINT [FK_Texts_User]

ALTER TABLE [dbo].[Texts]  WITH CHECK ADD  CONSTRAINT [FK_Texts_Text] FOREIGN KEY([fk_text])
REFERENCES [dbo].[Text] ([id_text])
ALTER TABLE [dbo].[Texts] CHECK CONSTRAINT [FK_Texts_Text]

ALTER TABLE [dbo].[Text]  WITH CHECK ADD  CONSTRAINT [FK_Text_Admin] FOREIGN KEY([fk_admin])
REFERENCES [dbo].[Admin] ([id_admin])
ALTER TABLE [dbo].[Text] CHECK CONSTRAINT [FK_Text_Admin]

ALTER TABLE [dbo].[Task]  WITH CHECK ADD  CONSTRAINT [FK_Task_KindOfTask] FOREIGN KEY([fk_kind])
REFERENCES [dbo].[KindOfTask] ([id_kot])
ALTER TABLE [dbo].[Task] CHECK CONSTRAINT [FK_Task_KindOfTask]

ALTER TABLE [dbo].[TaskList]  WITH CHECK ADD  CONSTRAINT [FK_TaskList_Task] FOREIGN KEY([fk_task])
REFERENCES [dbo].[Task] ([id_task])
ALTER TABLE [dbo].[TaskList] CHECK CONSTRAINT [FK_TaskList_Task]


go
Select*
from Text