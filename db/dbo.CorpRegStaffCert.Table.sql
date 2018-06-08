USE [WJSJZX]
GO
/****** Object:  Table [dbo].[CorpRegStaffCert]    Script Date: 2018/5/11 13:54:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CorpRegStaffCert](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[staff_id] [int] NULL,
	[staff_id_card] [varchar](50) NULL,
	[reg_type] [varchar](50) NOT NULL,
	[reg_type_id] [int] NULL,
	[reg_major] [varchar](50) NULL,
	[reg_major_id] [int] NULL,
	[cert_no] [varchar](50) NOT NULL,
	[reg_no] [varchar](50) NOT NULL,
	[valid_date] [datetime] NOT NULL,
	[create_time] [datetime] NOT NULL,
	[update_time] [datetime] NOT NULL,
	[status] [int] NOT NULL,
	[staff_id_card2] [varchar](50) NULL,
 CONSTRAINT [PK_CorpRegStaffCert] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

