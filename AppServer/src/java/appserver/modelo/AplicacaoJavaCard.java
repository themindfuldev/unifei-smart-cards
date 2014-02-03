
package appserver.modelo ;
/**
 * 
 *
 * @hibernate.class
 *     table="APLICACAO_JAVA_CARD"
 *
 */
public class AplicacaoJavaCard {
 
  // <editor-fold defaultstate="collapsed" desc=" Property:   String nome ">
  private String nome;
/**
  *   @hibernate.property
  */
   public String getNome () {
      return nome;
   } 
   public void setNome (String nome) {
      this.nome = nome;
   }
   // </editor-fold>
 
  // <editor-fold defaultstate="collapsed" desc=" Property:   String descricao ">
  private String descricao;
/**
  *   @hibernate.property
  */
   public String getDescricao () {
      return descricao;
   } 
   public void setDescricao (String descricao) {
      this.descricao = descricao;
   }
   // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc=" Property:   byte[] arquivo ">
   private byte[] arquivo;
   /**
    *   @hibernate.property
    *    type="binary"
    *    length="16000000"
    *    sql-type="mediumblob"
    * 
    */
   public byte[] getArquivo() {
       return arquivo;
   }
   public void setArquivo(byte[] arquivo) {
       this.arquivo = arquivo;
   }
   // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc=" PrimaryKey:   Long id ">
   private Long id;
/**
  *   @hibernate.id
  *     generator-class="hilo"
  *     column="id"
  *     type="java.lang.Long"
  *   @hibernate.column
  *     name="id"
  *     not-null="true"
  */
   public Long getId () {
      return id;
   } 
   public void setId (Long id) {
      this.id = id;
   }
   //</editor-fold>

}