USE [WJSJZX]
GO
/****** Object:  Table [dbo].[CorpCertType]    Script Date: 2018/5/11 13:54:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CorpCertType](
	[code] [int] NOT NULL,
	[certtype] [nvarchar](255) NULL
) ON [PRIMARY]

GO
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (1, N'工程勘察')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (2, N'工程设计')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (3, N'工程招标代理')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (4, N'建筑业')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (5, N'工程监理')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (6, N'工程造价咨询')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (7, N'城市规划')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (8, N'外商城市规划')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (9, N'城市园林绿化')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (10, N'设计与施工一体化')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (11, N'工程质量检测')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (12, N'施工图审查')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (13, N'房地产开发')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (14, N'房地产估价')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (15, N'房屋拆迁')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (16, N'物业服务')
INSERT [dbo].[CorpCertType] ([code], [certtype]) VALUES (20, N'安全生产许可证')
