USE [WJSJZX]
GO
/****** Object:  Table [dbo].[CorpRegStaff]    Script Date: 2018/5/11 13:54:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CorpRegStaff](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[corp_id] [varchar](50) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[gender] [int] NULL,
	[id_type] [varchar](50) NULL,
	[id_card] [varchar](50) NULL,
	[create_time] [datetime] NULL,
	[update_time] [datetime] NULL,
	[status] [int] NULL,
	[id_card2] [varchar](50) NULL,
 CONSTRAINT [PK_CorpRegStaff] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
