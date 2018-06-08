USE [WJSJZX]
GO
/****** Object:  Table [dbo].[Corp_Cert]    Script Date: 2018/5/11 13:54:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Corp_Cert](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[corp_id] [varchar](100) NOT NULL,
	[cert_type_id] [int] NULL,
	[cert_type] [varchar](50) NULL,
	[cert_no] [varchar](50) NULL,
	[cert_name] [varchar](200) NULL,
	[issue_date] [datetime] NULL,
	[valid_date] [datetime] NULL,
	[issue_authority] [varchar](100) NULL,
	[cert_level] [varchar](50) NULL,
	[status] [int] NULL,
	[trade_type_id] [int] NULL,
	[trade_type] [varchar](50) NULL,
	[major_type_id] [int] NULL,
	[major_type] [varchar](50) NULL,
	[statusLabel] [varchar](50) NULL,
	[create_time] [datetime] NULL,
	[update_time] [datetime] NULL,
	[tag] [varchar](20) NULL,
 CONSTRAINT [PK_CorpCertificate] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
