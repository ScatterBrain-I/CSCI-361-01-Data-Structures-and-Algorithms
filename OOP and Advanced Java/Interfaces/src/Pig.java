public class Pig implements IAnimal{
  private String m_name;

  public Pig(String name){
    m_name = name;
  }

  @Override
  public String makeSound(){
    String s = String.format("%s says: oink oink oink!", m_name);
    return s;
  }
}
