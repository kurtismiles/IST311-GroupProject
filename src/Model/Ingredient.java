package Model;

/**
 *
 * @author Kurtis
 */
public class Ingredient
{
    private String name;
    private String description;
    private String tags;
    
    public Ingredient(){}
    
    public Ingredient(String name, String description, String tags)
    {
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String tags) {
        this.tags = tags;
    }
    
    
    
}
