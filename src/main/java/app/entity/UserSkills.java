package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela USERSKILLS
 * @generated
 */
@Entity
@Table(name = "\"USERSKILLS\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.UserSkills")
public class UserSkills implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "cronuser_email", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String cronuser_email;

  /**
  * @generated
  */
  @Column(name = "level", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer level;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_skill", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Skill skill;

  /**
   * Construtor
   * @generated
   */
  public UserSkills(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public UserSkills setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém cronuser_email
   * return cronuser_email
   * @generated
   */
  
  public java.lang.String getCronuser_email(){
    return this.cronuser_email;
  }

  /**
   * Define cronuser_email
   * @param cronuser_email cronuser_email
   * @generated
   */
  public UserSkills setCronuser_email(java.lang.String cronuser_email){
    this.cronuser_email = cronuser_email;
    return this;
  }

  /**
   * Obtém level
   * return level
   * @generated
   */
  
  public java.lang.Integer getLevel(){
    return this.level;
  }

  /**
   * Define level
   * @param level level
   * @generated
   */
  public UserSkills setLevel(java.lang.Integer level){
    this.level = level;
    return this;
  }

  /**
   * Obtém skill
   * return skill
   * @generated
   */
  
  public Skill getSkill(){
    return this.skill;
  }

  /**
   * Define skill
   * @param skill skill
   * @generated
   */
  public UserSkills setSkill(Skill skill){
    this.skill = skill;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    UserSkills object = (UserSkills)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
