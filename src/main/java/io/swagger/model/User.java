package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-05T10:37:58.829+01:00")

public class User   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("surname")
  private String surname = null;

  @JsonProperty("age")
  private Integer age = null;

  @JsonProperty("personalId")
  private String personalId = null;

  /**
   * Gets or Sets citizenship
   */
  public enum CitizenshipEnum {
    PL("PL"),
    
    DE("DE"),
    
    UK("UK");

    private String value;

    CitizenshipEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CitizenshipEnum fromValue(String text) {
      for (CitizenshipEnum b : CitizenshipEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("citizenship")
  private CitizenshipEnum citizenship = null;

  @JsonProperty("email")
  private String email = null;

  public User id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Elon", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  **/
  @ApiModelProperty(example = "Musk", required = true, value = "")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public User age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * minimum: 1
   * @return age
  **/
  @ApiModelProperty(example = "10", required = true, value = "")
  @NotNull

@Min(1)
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public User personalId(String personalId) {
    this.personalId = personalId;
    return this;
  }

  /**
   * Get personalId
   * @return personalId
  **/
  @ApiModelProperty(example = "92011165987", required = true, value = "")
  @NotNull

@Pattern(regexp="^[0-9]{11}$") 
  public String getPersonalId() {
    return personalId;
  }

  public void setPersonalId(String personalId) {
    this.personalId = personalId;
  }

  public User citizenship(CitizenshipEnum citizenship) {
    this.citizenship = citizenship;
    return this;
  }

  /**
   * Get citizenship
   * @return citizenship
  **/
  @ApiModelProperty(example = "PL", required = true, value = "")
  @NotNull

@Pattern(regexp="^[A-Z]{2}$") 
  public CitizenshipEnum getCitizenship() {
    return citizenship;
  }

  public void setCitizenship(CitizenshipEnum citizenship) {
    this.citizenship = citizenship;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(example = "e_musk@gmail.com", value = "")

@Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") 
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.surname, user.surname) &&
        Objects.equals(this.age, user.age) &&
        Objects.equals(this.personalId, user.personalId) &&
        Objects.equals(this.citizenship, user.citizenship) &&
        Objects.equals(this.email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, age, personalId, citizenship, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    personalId: ").append(toIndentedString(personalId)).append("\n");
    sb.append("    citizenship: ").append(toIndentedString(citizenship)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

