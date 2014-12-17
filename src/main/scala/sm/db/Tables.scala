package sm.db
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.SQLiteDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}

  /** Entity class storing rows of table Author
   *  @param id Database column Id DBType(INTEGER)
   *  @param name Database column Name DBType(VARCHAR), Length(100,true) */
  case class author(id: Option[Int], name: Option[String])
  /** GetResult implicit for fetching author objects using plain SQL queries */
  implicit def GetResultauthor(implicit e0: GR[Option[Int]], e1: GR[Option[String]]): GR[author] = GR{
    prs => import prs._
    author.tupled((<<?[Int], <<?[String]))
  }
  
  /** Entity class storing rows of table Citation
   *  @param fromdocumentitemid Database column FromDocumentItemId DBType(INTEGER)
   *  @param todocumentitemid Database column ToDocumentItemId DBType(INTEGER) */
  case class citation(fromdocumentitemid: Option[Int], todocumentitemid: Option[Int])
  /** GetResult implicit for fetching citation objects using plain SQL queries */
  implicit def GetResultcitation(implicit e0: GR[Option[Int]]): GR[citation] = GR{
    prs => import prs._
    citation.tupled((<<?[Int], <<?[Int]))
  }
  
  /** Entity class storing rows of table Documentauthor
   *  @param documentitemid Database column DocumentItemId DBType(INTEGER)
   *  @param authorid Database column AuthorId DBType(INTEGER) */
  case class documentauthor(documentitemid: Option[Int], authorid: Option[Int])
  /** GetResult implicit for fetching documentauthor objects using plain SQL queries */
  implicit def GetResultdocumentauthor(implicit e0: GR[Option[Int]]): GR[documentauthor] = GR{
    prs => import prs._
    documentauthor.tupled((<<?[Int], <<?[Int]))
  }
  
  /** Entity class storing rows of table Documentfolder
   *  @param id Database column Id DBType(INTEGER)
   *  @param userid Database column UserId DBType(VARCHAR), Length(20,true)
   *  @param name Database column Name DBType(VARCHAR), Length(100,true)
   *  @param description Database column Description DBType(VARCHAR), Length(1000,true)
   *  @param created Database column Created DBType(DATE)
   *  @param modified Database column Modified DBType(DATE) */
  case class documentfolder(id: Option[Int], userid: Option[String], name: Option[String], description: Option[String], created: Option[java.sql.Date], modified: Option[java.sql.Date])
  /** GetResult implicit for fetching documentfolder objects using plain SQL queries */
  implicit def GetResultdocumentfolder(implicit e0: GR[Option[Int]], e1: GR[Option[String]], e2: GR[Option[java.sql.Date]]): GR[documentfolder] = GR{
    prs => import prs._
    documentfolder.tupled((<<?[Int], <<?[String], <<?[String], <<?[String], <<?[java.sql.Date], <<?[java.sql.Date]))
  }
  
  /** Entity class storing rows of table Documentitem
   *  @param id Database column Id DBType(INTEGER)
   *  @param documentfolderid Database column DocumentFolderId DBType(INTEGER)
   *  @param `abstract` Database column Abstract DBType(VARCHAR), Length(5000,true)
   *  @param isprofiled Database column IsProfiled DBType(BOOLEAN)
   *  @param profiled Database column Profiled DBType(DATE)
   *  @param description Database column Description DBType(VARCHAR), Length(1000,true)
   *  @param created Database column Created DBType(DATE)
   *  @param modified Database column Modified DBType(DATE)
   *  @param source Database column Source DBType(VARCHAR), Length(1000,true) */
  case class documentitem(id: Option[Int], documentfolderid: Option[Int], `abstract`: Option[String], isprofiled: Option[Int], profiled: Option[java.sql.Date], description: Option[String], created: Option[java.sql.Date], modified: Option[java.sql.Date], source: Option[String])
  /** GetResult implicit for fetching documentitem objects using plain SQL queries */
  implicit def GetResultdocumentitem(implicit e0: GR[Option[Int]], e1: GR[Option[String]], e2: GR[Option[java.sql.Date]]): GR[documentitem] = GR{
    prs => import prs._
    documentitem.tupled((<<?[Int], <<?[Int], <<?[String], <<?[Int], <<?[java.sql.Date], <<?[String], <<?[java.sql.Date], <<?[java.sql.Date], <<?[String]))
  }
  
  /** Entity class storing rows of table Matchfolder
   *  @param id Database column Id DBType(INTEGER)
   *  @param userid Database column UserId DBType(VARCHAR), Length(20,true)
   *  @param name Database column Name DBType(VARCHAR), Length(100,true)
   *  @param documentfolderid1 Database column DocumentFolderId1 DBType(INTEGER)
   *  @param documentfolderid2 Database column DocumentFolderId2 DBType(INTEGER)
   *  @param description Database column Description DBType(VARCHAR), Length(1000,true)
   *  @param created Database column Created DBType(DATE)
   *  @param modified Database column Modified DBType(DATE)
   *  @param limit Database column Limit DBType(REAL)
   *  @param threshold Database column Threshold DBType(REAL) */
  case class matchfolder(id: Option[Int], userid: Option[String], name: Option[String], documentfolderid1: Option[Int], documentfolderid2: Option[Int], description: Option[String], created: Option[java.sql.Date], modified: Option[java.sql.Date], limit: Option[Double], threshold: Option[Double])
  /** GetResult implicit for fetching matchfolder objects using plain SQL queries */
  implicit def GetResultmatchfolder(implicit e0: GR[Option[Int]], e1: GR[Option[String]], e2: GR[Option[java.sql.Date]], e3: GR[Option[Double]]): GR[matchfolder] = GR{
    prs => import prs._
    matchfolder.tupled((<<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[String], <<?[java.sql.Date], <<?[java.sql.Date], <<?[Double], <<?[Double]))
  }
  
  /** Entity class storing rows of table Matchitem
   *  @param id Database column Id DBType(INTEGER)
   *  @param matchfolderid Database column MatchFolderId DBType(INTEGER)
   *  @param documentitemid1 Database column DocumentItemId1 DBType(INTEGER)
   *  @param documentitemid2 Database column DocumentItemId2 DBType(INTEGER)
   *  @param score Database column Score DBType(REAL) */
  case class matchitem(id: Option[Int], matchfolderid: Option[Int], documentitemid1: Option[Int], documentitemid2: Option[Int], score: Option[Double])
  /** GetResult implicit for fetching matchitem objects using plain SQL queries */
  implicit def GetResultmatchitem(implicit e0: GR[Option[Int]], e1: GR[Option[Double]]): GR[matchitem] = GR{
    prs => import prs._
    matchitem.tupled((<<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Double]))
  }
  
  /** Entity class storing rows of table Token
   *  @param userid Database column UserId DBType(VARCHAR), Length(20,true)
   *  @param token Database column Token DBType(VARCHAR), Length(100,true)
   *  @param expires Database column Expires DBType(DATE) */
  case class token(userid: Option[String], token: Option[String], expires: Option[java.sql.Date])
  /** GetResult implicit for fetching token objects using plain SQL queries */
  implicit def GetResulttoken(implicit e0: GR[Option[String]], e1: GR[Option[java.sql.Date]]): GR[token] = GR{
    prs => import prs._
    token.tupled((<<?[String], <<?[String], <<?[java.sql.Date]))
  }
  
  /** Entity class storing rows of table User
   *  @param userid Database column UserId DBType(VARCHAR), Length(20,true)
   *  @param password Database column Password DBType(VARCHAR), Length(100,true) */
  case class user(userid: Option[String], password: Option[String])
  /** GetResult implicit for fetching user objects using plain SQL queries */
  implicit def GetResultuser(implicit e0: GR[Option[String]]): GR[user] = GR{
    prs => import prs._
    user.tupled((<<?[String], <<?[String]))
  }
}