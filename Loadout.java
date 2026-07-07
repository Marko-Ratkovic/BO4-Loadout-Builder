package com.bo4loadouts.model;

/**
 * This is the representation of the loadout/class object.
 * 
 * @author Marko
 */
public class Loadout {
    
    /**
     * Default constructor
     */
    public Loadout() {
        
    }
    
    /**
     * Unique identifier for the loadout. 
     */
    private int id;
    
    /**
     * Display name of the loadout.
     */
    private String title;
    
    /**
     * Short description of the purpose or play-style of the loadout.
     */
    private String description;
    
    /**
     * Total number of pick 10 slots used with a max of 10.
     */
    private int pickTotal;
    
    /**
     * Shows the total views of the loadout.
     */
    private int viewCount;
    
    /**
     * Shows the number of likes the loadout has received.
     */
    private int likeCount;
    
    /**
     * Determines whether this loadout is marked as featured on the homepage.
     */
    private boolean featured;
    
    /**
     * The date the loadout was created, formatted as Year-Month-Day
     */
    private String createdAt;
    
    /**
     * Name of the primary weapon used in the game.
     */
    private String primaryWeaponName;
    
    /**
     * Image URL of the weapon used in the game.
     */
    private String primaryWeaponImage;
    
    /**
     * The category that weapon is classified as.
     */
    private String primaryWeaponCategory;
    
    /**
     * The name of the optic that can be equipped on the primary weapon.
     */
    private String primaryOpticName;
    
    /**
     * The image URL of the optic.
     */
    private String primaryOpticImage;
    
    /**
     * The primary weapon attachment equipped on slot 1.
     */
    private String primaryAt1Name;
    
    /**
     * The image URL of the primary weapon attachment equipped on slot 1.
     */
    private String primaryAt1Image;
    
    /**
     * The primary weapon attachment equipped on slot 2.
     */
    private String primaryAt2Name;
    
    /**
     * The image URL of the primary weapon attachment equipped on slot 2.
     */
    private String primaryAt2Image;
    
    /**
     * The primary weapon attachment equipped on slot 3.
     */
    private String primaryAt3Name;
    
    /**
     * The image URL of the primary weapon attachment equipped on slot 3.
     */
    private String primaryAt3Image;
    
    /**
     * The primary weapon attachment equipped on slot 4.
     */
    private String primaryAt4Name;
    
    /**
     * The image URL of the primary weapon attachment equipped on slot 4.
     */
    private String primaryAt4Image;
    
    /**
     * The primary weapon attachment equipped on slot 5.
     */
    private String primaryAt5Name;
    
    /**
     * The image URL of the primary weapon attachment equipped on slot 5.
     */
    private String primaryAt5Image;
 
    /**
     * Name of the secondary weapon used in the game.
     */
    private String secondaryWeaponName;
    
    /**
     * Image URL of the weapon used in the game.
     */
    private String secondaryWeaponImage;
    
    /**
     * The category that weapon is classified as.
     */
    private String secondaryWeaponCategory;
 
    /**
     * The name of the optic that can be equipped on the secondary weapon.
     */
    private String secondaryOpticName;
    
    /**
     * The image URL of the optic.
     */
    private String secondaryOpticImage;
 
    /**
     * The secondary weapon attachment equipped on slot 1.
     */
    private String secondaryAt1Name;
    
    /**
     * The image URL of the secondary weapon attachment equipped on slot 1.
     */
    private String secondaryAt1Image;
    
    /**
     * The secondary weapon attachment equipped on slot 2.
     */
    private String secondaryAt2Name;
    
    /**
     * The image URL of the secondary weapon attachment equipped on slot 2.
     */
    private String secondaryAt2Image;
    
    /**
     * The secondary weapon attachment equipped on slot 3.
     */
    private String secondaryAt3Name;
    
    /**
     * The image URL of the secondary weapon attachment equipped on slot 3.
     */
    private String secondaryAt3Image;
    
    /**
     * The secondary weapon attachment equipped on slot 4.
     */
    private String secondaryAt4Name;
    
    /**
     * The image URL of the secondary weapon attachment equipped on slot 4.
     */
    private String secondaryAt4Image;
    
    /**
     * The secondary weapon attachment equipped on slot 5.
     */
    private String secondaryAt5Name;
    
    /**
     * The image URL of the secondary weapon attachment equipped on slot 5.
     */
    private String secondaryAt5Image;
 
    /**
     * The name of the tier 1 perk in slot 1.
     */
    private String perk1Slot1Name;
    
    /**
     * The image URL of the tier 1 perk in slot 1.
     */
    private String perk1Slot1Image;
    
    /**
     * The name of the tier 1 perk in slot 2.
     */
    private String perk1Slot2Name;
    
    /**
     * The image URL of the tier 1 perk in slot 2.
     */
    private String perk1Slot2Image;
    
    /**
     * The name of the tier 2 perk in slot 1.
     */
    private String perk2Slot1Name;
    
    /**
     * The image URL of the tier 2 perk in slot 1.
     */
    private String perk2Slot1Image;
    
    /**
     * The name of the tier 2 perk in slot 2.
     */
    private String perk2Slot2Name;
    
    /**
     * The image URL of the tier 2 perk in slot 2.
     */
    private String perk2Slot2Image;
    
    /**
     * The name of the tier 3 perk in slot 1.
     */
    private String perk3Slot1Name;
    
    /**
     * The image URL of the tier 3 perk in slot 1.
     */
    private String perk3Slot1Image;
    
    /**
     * The name of the tier 3 perk in slot 2.
     */
    private String perk3Slot2Name;
    
    /**
     * The image URL of the tier 3 perk in slot 2.
     */
    private String perk3Slot2Image;
 
    /**
     * The name of the gear that can be equipped in the gear slot.
     */
    private String gearName;
    
    /**
     * The image URL of the gear that can be equipped in the gear slot.
     */
    private String gearImage;
    
    /**
     * The name of the equipment that can be equipped in the equipment slot.
     */
    private String equipmentName;
    
    /**
     * The image URL of the equipment that can be equipped in the equipment slot.
     */
    private String equipmentImage;
 
    /**
     * The wildcard name that can be equipped in slot 1.
     */
    private String wildcard1Name;
    
    /**
     * The image URL of the wildcard that can equipped in slot 1.
     */
    private String wildcard1Image;
    
    /**
     * The wildcard name that can be equipped in slot 2.
     */
    private String wildcard2Name;
    
    /**
     * The image URL of the wildcard that can equipped in slot 2.
     */
    private String wildcard2Image;
    
    /**
     * The wildcard name that can be equipped in slot 3.
     */
    private String wildcard3Name;
    
    /**
     * The image URL of the wildcard that can be equipped in slot 3.
     */
    private String wildcard3Image;
    
    // ── Getters & Setters
    
    /**
     * Getter method that gets the id or unique identifier of the particular loadout.
     * 
     * @return ID of the loadout from the database.
     */
    public int getId() { 
        return id;
    }
    
    /**
     * Setter method that sets the unique identifier for a particular loadout.
     * 
     * @param id the loadout ID from the database.
     */
    public void setId(int id) {
        this.id = id;
    }
 
    /**
     * Getter method that gets the tile of the particular loadout.
     * 
     * @return the title of the loadout from the database.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Setter method that sets the title for a particular loadout.
     * 
     * @param title the loadout title from the database.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Getter method that gets the description of the particular loadout.
     * 
     * @return the description of the loadout from the database.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Setter method that sets the description for a particular loadout.
     * 
     * @param description the loadout description from the database.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Getter method that gets the pick 10 total of the particular loadout.
     * 
     * @return the pick 10 total of a particular loadout as an int.
     */
    public int getPickTotal() {
        return pickTotal;
    }
    
    /**
     * Setter method that sets the pick 10 total of the particular loadout.
     * 
     * @param pickTotal the pick 10 total of a particular loadout from the database. 
     */
    public void setPickTotal(int pickTotal) {
        this.pickTotal = pickTotal;
    }
 
   /**
    * Getter method that gets the number of views for the particular loadout.
    * 
    * @return the number of views for the loadoutas an int.
    */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * Setter method that sets the number of views for a particular loadout.
     * 
     * @param viewCount the number of views for the loadout from the database.
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * Getter method that gets the number of likes for the particular loadout.
     * 
     * @return the number of likes for the loadout as an int.
     */
    public int getLikeCount() {
        return likeCount;
    }

    /**
     * Setter method that sets the number of likes for a particular loadout.
     * 
     * @param likeCount the number of likes for the loadout from the database.
     */
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * Getter method that gets whether the particular loadout is featured.
     * 
     * @return true if the loadout is featured; otherwise false.
     */
    public boolean isFeatured() {
        return featured;
    }

    /**
     * Setter method that sets whether a particular loadout is featured.
     * 
     * @param featured true if the loadout should be featured; otherwise false from the database.
     */
    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    /**
     * Getter method that gets the date and time the particular loadout was created.
     * 
     * @return the creation date and time of the loadout.
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Setter method that sets the creation date and time for a particular loadout.
     * 
     * @param createdAt the creation date and time of the loadout from the database.
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
 
    /**
     * Getter method that gets the name of the primary weapon.
     * 
     * @return the name of the primary weapon.
     */
   public String getPrimaryWeaponName() {
       return primaryWeaponName;
    }

    /**
     * Setter method that sets the name of the primary weapon.
     * 
     * @param v the name of the primary weapon from the database.
     */
    public void setPrimaryWeaponName(String v) {
        this.primaryWeaponName = v;
    }

    /**
     * Getter method that gets the image URL of the primary weapon.
     * 
     * @return the image URL of the primary weapon.
     */
    public String getPrimaryWeaponImage() {
        return primaryWeaponImage;
    }

    /**
     * Setter method that sets the image URL of the primary weapon.
     * 
     * @param v the image URL of the primary weapon from the database.
     */
    public void setPrimaryWeaponImage(String v) {
        this.primaryWeaponImage = v;
    }

    /**
     * Getter method that gets the category of the primary weapon.
     * 
     * @return the category of the primary weapon.
     */
    public String getPrimaryWeaponCategory() {
        return primaryWeaponCategory;
    }

    /**
     * Setter method that sets the category of the primary weapon.
     * 
     * @param v the category of the primary weapon from the database.
     */
    public void setPrimaryWeaponCategory(String v) {
        this.primaryWeaponCategory = v;
    }
 
    /**
     * Getter method that gets the name of the primary optic.
     * 
     * @return the name of the primary optic.
     */
    public String getPrimaryOpticName() {
        return primaryOpticName;
    }

    /**
     * Setter method that sets the name of the primary optic.
     * 
     * @param v the name of the primary optic from the database.
     */
    public void setPrimaryOpticName(String v) {
        this.primaryOpticName = v;
    }

    /**
     * Getter method that gets the image URL of the primary optic.
     * 
     * @return the image URL of the primary optic.
     */
    public String getPrimaryOpticImage() {
        return primaryOpticImage;
    }

    /**
     * Setter method that sets the image URL of the primary optic.
     * 
     * @param v the image URL of the primary optic from the database.
     */
    public void setPrimaryOpticImage(String v) {
        this.primaryOpticImage = v;
    }
 
    /**
     * Getter method that gets the name of the first primary attachment.
     * 
     * @return the name of the first primary attachment.
     */
    public String getPrimaryAt1Name() {
        return primaryAt1Name;
    }

    /**
     * Setter method that sets the name of the first primary attachment.
     * 
     * @param v the name of the first primary attachment from the database.
     */
    public void setPrimaryAt1Name(String v) {
        this.primaryAt1Name = v;
    }

    /**
     * Getter method that gets the image URL of the first primary attachment.
     * 
     * @return the image URL of the first primary attachment.
     */
    public String getPrimaryAt1Image() {
        return primaryAt1Image;
    }

    /**
     * Setter method that sets the image URL of the first primary attachment.
     * 
     * @param v the image URL of the first primary attachment from the database.
     */
    public void setPrimaryAt1Image(String v) {
        this.primaryAt1Image = v;
    }

    /**
     * Getter method that gets the name of the second primary attachment.
     * 
     * @return the name of the second primary attachment.
     */
    public String getPrimaryAt2Name() {
        return primaryAt2Name;
    }

    /**
     * Setter method that sets the name of the second primary attachment.
     * 
     * @param v the name of the second primary attachment from the database.
     */
    public void setPrimaryAt2Name(String v) {
        this.primaryAt2Name = v;
    }

    /**
     * Getter method that gets the image URL of the second primary attachment.
     * 
     * @return the image URL of the second primary attachment.
     */
    public String getPrimaryAt2Image() {
        return primaryAt2Image;
    }

    /**
     * Setter method that sets the image URL of the second primary attachment.
     * 
     * @param v the image URL of the second primary attachment from the database.
     */
    public void setPrimaryAt2Image(String v) {
        this.primaryAt2Image = v;
    }
    
    /**
     * Getter method that gets the name of the third primary attachment.
     * 
     * @return the name of the third primary attachment.
     */
    public String getPrimaryAt3Name() {
        return primaryAt3Name;
    }
    
    /**
     * Setter method that sets the name of the third primary attachment.
     * 
     * @param v the name of the third primary attachment from the database.
     */
    public void setPrimaryAt3Name(String v) {
        this.primaryAt3Name = v;
    }
    
    /**
     * Getter method that gets the image URL of the third primary attachment.
     * 
     * @return the image URL of the third primary attachment.
     */
    public String getPrimaryAt3Image() {
        return primaryAt3Image;
    }
    
    /**
     * Setter method that sets the image URL of the third primary attachment.
     * 
     * @param v the image URL of the third primary attachment from the database.
     */
    public void setPrimaryAt3Image(String v) {
        this.primaryAt3Image = v;
    }
    
    /**
     * Getter method that gets the name of the fourth primary attachment.
     * 
     * @return the name of the fourth primary attachment.
     */
    public String getPrimaryAt4Name() {
        return primaryAt4Name;
    }
    
    /**
     * Setter method that sets the name of the fourth primary attachment.
     * 
     * @param v the name of the fourth primary attachment from the database.
     */
    public void setPrimaryAt4Name(String v) {
        this.primaryAt4Name = v;
    }
    
    /**
     * Getter method that gets the image URL of the fourth primary attachment.
     * 
     * @return the image URL of the fourth primary attachment.
     */
    public String getPrimaryAt4Image() {
        return primaryAt4Image;
    }
    
    /**
     * Setter method that sets the image URL of the fourth primary attachment.
     * 
     * @param v the image URL of the fourth primary attachment from the database.
     */
    public void setPrimaryAt4Image(String v) {
        this.primaryAt4Image = v;
    }
    
    /**
     * Getter method that gets the name of the fifth primary attachment.
     * 
     * @return the name of the fifth primary attachment.
     */
    public String getPrimaryAt5Name() {
        return primaryAt5Name;
    }
    
    /**
     * Setter method that sets the name of the fifth primary attachment.
     * 
     * @param v the name of the fifth primary attachment from the database.
     */
    public void setPrimaryAt5Name(String v) {
        this.primaryAt5Name = v;
    }

    /**
     * Getter method that gets the image URL of the fifth primary attachment.
     * 
     * @return the image URL of the fifth primary attachment.
     */
    public String getPrimaryAt5Image() {
        return primaryAt5Image;
    }

    /**
     * Setter method that sets the image URL of the fifth primary attachment.
     * 
     * @param v the image URL of the fifth primary attachment from the database.
     */
    public void setPrimaryAt5Image(String v) {
        this.primaryAt5Image = v;
    }
 
    /**
     * Getter method that gets the name of the secondary weapon.
     * 
     * @return the name of the secondary weapon.
     */
    public String getSecondaryWeaponName() {
        return secondaryWeaponName;
    }

    /**
     * Setter method that sets the name of the secondary weapon.
     * 
     * @param v the name of the secondary weapon from the database.
     */
    public void setSecondaryWeaponName(String v) {
        this.secondaryWeaponName = v;
    }

    /**
     * Getter method that gets the image URL of the secondary weapon.
     * 
     * @return the image URL of the secondary weapon.
     */
    public String getSecondaryWeaponImage() {
        return secondaryWeaponImage;
    }

    /**
     * Setter method that sets the image URL of the secondary weapon.
     * 
     * @param v the image URL of the secondary weapon from the database.
     */
    public void setSecondaryWeaponImage(String v) {
        this.secondaryWeaponImage = v;
    }

    /**
     * Getter method that gets the category of the secondary weapon.
     * 
     * @return the category of the secondary weapon.
     */
    public String getSecondaryWeaponCategory() {
        return secondaryWeaponCategory;
    }

    /**
     * Setter method that sets the category of the secondary weapon.
     * 
     * @param v the category of the secondary weapon from the database.
     */
    public void setSecondaryWeaponCategory(String v) {
        this.secondaryWeaponCategory = v;
    }
    
    /**
     * Getter method that gets the name of the secondary optic.
     * 
     * @return the name of the secondary optic.
     */
    public String getSecondaryOpticName() {
        return secondaryOpticName;
    }

    /**
     * Setter method that sets the name of the secondary optic.
     * 
     * @param v the name of the secondary optic from the database.
     */
    public void setSecondaryOpticName(String v) {
        this.secondaryOpticName = v;
    }

    /**
     * Getter method that gets the image URL of the secondary optic.
     * 
     * @return the image URL of the secondary optic.
     */
    public String getSecondaryOpticImage() {
        return secondaryOpticImage;
    }

    /**
     * Setter method that sets the image URL of the secondary optic.
     * 
     * @param v the image URL of the secondary optic from the database.
     */
    public void setSecondaryOpticImage(String v) {
        this.secondaryOpticImage = v;
    }

    /**
     * Getter method that gets the name of the first secondary attachment.
     * 
     * @return the name of the first secondary attachment.
     */
    public String getSecondaryAt1Name() {
        return secondaryAt1Name;
    }

    /**
     * Setter method that sets the name of the first secondary attachment.
     * 
     * @param v the name of the first secondary attachment from the database.
     */
    public void setSecondaryAt1Name(String v) {
        this.secondaryAt1Name = v;
    }

    /**
     * Getter method that gets the image URL of the first secondary attachment.
     * 
     * @return the image URL of the first secondary attachment.
     */
    public String getSecondaryAt1Image() {
        return secondaryAt1Image;
    }

    /**
     * Setter method that sets the image URL of the first secondary attachment.
     * 
     * @param v the image URL of the first secondary attachment from the database.
     */
    public void setSecondaryAt1Image(String v) {
        this.secondaryAt1Image = v;
    }

    /**
     * Getter method that gets the name of the second secondary attachment.
     * 
     * @return the name of the second secondary attachment.
     */
    public String getSecondaryAt2Name() {
        return secondaryAt2Name;
    }

    /**
     * Setter method that sets the name of the second secondary attachment.
     * 
     * @param v the name of the second secondary attachment from the database.
     */
    public void setSecondaryAt2Name(String v) {
        this.secondaryAt2Name = v;
    }

    /**
     * Getter method that gets the image URL of the second secondary attachment.
     * 
     * @return the image URL of the second secondary attachment.
     */
    public String getSecondaryAt2Image() {
        return secondaryAt2Image;
    }

    /**
     * Setter method that sets the image URL of the second secondary attachment.
     * 
     * @param v the image URL of the second secondary attachment from the database.
     */
    public void setSecondaryAt2Image(String v) {
        this.secondaryAt2Image = v;
    }

    /**
     * Getter method that gets the name of the third secondary attachment.
     * 
     * @return the name of the third secondary attachment.
     */
    public String getSecondaryAt3Name() {
        return secondaryAt3Name;
    }

    /**
     * Setter method that sets the name of the third secondary attachment.
     * 
     * @param v the name of the third secondary attachment from the database.
     */
    public void setSecondaryAt3Name(String v) {
        this.secondaryAt3Name = v;
    }

    /**
     * Getter method that gets the image URL of the third secondary attachment.
     * 
     * @return the image URL of the third secondary attachment.
     */
    public String getSecondaryAt3Image() {
        return secondaryAt3Image;
    }

    /**
     * Setter method that sets the image URL of the third secondary attachment.
     * 
     * @param v the image URL of the third secondary attachment from the database.
     */
    public void setSecondaryAt3Image(String v) {
        this.secondaryAt3Image = v;
    }

    /**
     * Getter method that gets the name of the fourth secondary attachment.
     * 
     * @return the name of the fourth secondary attachment.
     */
    public String getSecondaryAt4Name() {
        return secondaryAt4Name;
    }

    /**
     * Setter method that sets the name of the fourth secondary attachment.
     * 
     * @param v the name of the fourth secondary attachment from the database.
     */
    public void setSecondaryAt4Name(String v) {
        this.secondaryAt4Name = v;
    }

    /**
     * Getter method that gets the image URL of the fourth secondary attachment.
     * 
     * @return the image URL of the fourth secondary attachment.
     */
    public String getSecondaryAt4Image() {
        return secondaryAt4Image;
    }

    /**
     * Setter method that sets the image URL of the fourth secondary attachment.
     * 
     * @param v the image URL of the fourth secondary attachment from the database.
     */
    public void setSecondaryAt4Image(String v) {
        this.secondaryAt4Image = v;
    }

    /**
     * Getter method that gets the name of the fifth secondary attachment.
     * 
     * @return the name of the fifth secondary attachment.
     */
    public String getSecondaryAt5Name() {
        return secondaryAt5Name;
    }

    /**
     * Setter method that sets the name of the fifth secondary attachment.
     * 
     * @param v the name of the fifth secondary attachment from the database.
     */
    public void setSecondaryAt5Name(String v) {
        this.secondaryAt5Name = v;
    }

    /**
     * Getter method that gets the image URL of the fifth secondary attachment.
     * 
     * @return the image URL of the fifth secondary attachment.
     */
    public String getSecondaryAt5Image() {
        return secondaryAt5Image;
    }

    /**
     * Setter method that sets the image URL of the fifth secondary attachment.
     * 
     * @param v the image URL of the fifth secondary attachment from the database.
     */
    public void setSecondaryAt5Image(String v) {
        this.secondaryAt5Image = v;
    }
 
    /**
     * Getter method that gets the name of the first perk equipped in tier 1 slot 1.
     * 
     * @return the name of the first perk in tier 1 slot 1.
     */
    public String getPerk1Slot1Name() {
        return perk1Slot1Name;
    }

    /**
     * Setter method that sets the name of the first perk equipped in tier 1 slot 1.
     * 
     * @param v the name of the first perk in tier 1 slot 1 from the database.
     */
    public void setPerk1Slot1Name(String v) {
        this.perk1Slot1Name = v;
    }

    /**
     * Getter method that gets the image URL of the first perk equipped in tier 1 slot 1.
     * 
     * @return the image URL of the first perk equipped in tier 1 slot 1.
     */
    public String getPerk1Slot1Image() {
        return perk1Slot1Image;
    }

    /**
     * Setter method that sets the image URL of the first perk equipped in tier 1 slot 1.
     * 
     * @param v the image URL of the first perk equipped in tier 1 slot 1 from the database.
     */
    public void setPerk1Slot1Image(String v) {
        this.perk1Slot1Image = v;
    }

    /**
     * Getter method that gets the name of the second perk equipped in tier 1 slot 2.
     * 
     * @return the name of the second perk equipped in tier 1 slot 2.
     */
    public String getPerk1Slot2Name() {
        return perk1Slot2Name;
    }

    /**
     * Setter method that sets the name of the second perk equipped in tier 1 slot 2.
     * 
     * @param v the name of the second perk equipped in tier 1 slot 2 from the database.
     */
    public void setPerk1Slot2Name(String v) {
        this.perk1Slot2Name = v;
    }

    /**
     * Getter method that gets the image URL of the second perk equipped in tier 1 slot 2.
     * 
     * @return the image URL of the second perk in tier 1 slot 2.
     */
    public String getPerk1Slot2Image() {
        return perk1Slot2Image;
    }

    /**
     * Setter method that sets the image URL of the second perk equipped in tier 1 slot 2.
     * 
     * @param v the image URL of the second perk in tier 1 slot 2 from the database.
     */
    public void setPerk1Slot2Image(String v) {
        this.perk1Slot2Image = v;
    }

    /**
     * Getter method that gets the name of the first perk in tier 2 slot 1.
     * 
     * @return the name of the first perk in tier 2 perk slot 1.
     */
    public String getPerk2Slot1Name() {
        return perk2Slot1Name;
    }

    /**
     * Setter method that sets the name of the first perk in tier 2 slot 1.
     * 
     * @param v the name of the first perk in tier 2 perk slot 1 from the database.
     */
    public void setPerk2Slot1Name(String v) {
        this.perk2Slot1Name = v;
    }

    /**
     * Getter method that gets the image URL of the first perk in tier 2 slot 1.
     * 
     * @return the image URL of the first perk in tier 1 perk slot 1.
     */
    public String getPerk2Slot1Image() {
        return perk2Slot1Image;
    }

    /**
     * Setter method that sets the image URL of the first perk in tier 2 slot 1.
     * 
     * @param v the image URL of the first perk in tier 2 perk slot 1.
     */
    public void setPerk2Slot1Image(String v) {
        this.perk2Slot1Image = v;
    }

    /**
     * Getter method that gets the name of the second perk in tier 2 slot 2.
     * 
     * @return the name of the second perk in tier 2 perk slot 2.
     */
    public String getPerk2Slot2Name() {
        return perk2Slot2Name;
    }

    /**
     * Setter method that sets the name of the second perk in tier 2 slot 2.
     * 
     * @param v the name of the second perk in tier 2 perk slot 2 from the database.
     */
    public void setPerk2Slot2Name(String v) {
        this.perk2Slot2Name = v;
    }

    /**
     * Getter method that gets the image URL of the second perk in tier 2 slot 2.
     * 
     * @return the image URL of the second perk in tier 2 perk slot 2.
     */
    public String getPerk2Slot2Image() {
        return perk2Slot2Image;
    }

    /**
     * Setter method that sets the image URL of the second perk in tier 2 slot 2.
     * 
     * @param v the image URL of the second perk in tier 2 perk slot 2 from the database.
     */
    public void setPerk2Slot2Image(String v) {
        this.perk2Slot2Image = v;
    }

    /**
     * Getter method that gets the name of the first perk in tier 3 slot 1.
     * 
     * @return the name of the first perk in tier 3 perk slot 1.
     */
    public String getPerk3Slot1Name() {
        return perk3Slot1Name;
    }

    /**
     * Setter method that sets the name of the first perk in tier 3 slot 1.
     * 
     * @param v the name of the first perk in tier 3 perk slot 1 from the database.
     */
    public void setPerk3Slot1Name(String v) {
        this.perk3Slot1Name = v;
    }

    /**
     * Getter method that gets the image URL of the first perk tier 3 slot 1.
     * 
     * @return the image URL of the first perk in tier 3 perk slot 1.
     */
    public String getPerk3Slot1Image() {
        return perk3Slot1Image;
    }

    /**
     * Setter method that sets the image URL of the first perk in tier 3 slot 1.
     * 
     * @param v the image URL of the first perk in tier 3 perk slot 1 from the database.
     */
    public void setPerk3Slot1Image(String v) {
        this.perk3Slot1Image = v;
    }

    /**
     * Getter method that gets the name of the second perk in tier 3 perk slot 2.
     * 
     * @return the name of the second perk in tier 3 perk slot 2.
     */
    public String getPerk3Slot2Name() {
        return perk3Slot2Name;
    }

    /**
     * Setter method that sets the name of the second perk in tier 3 slot 2.
     * 
     * @param v the name of the second perk in tier 3 perk slot 2 from the database.
     */
    public void setPerk3Slot2Name(String v) {
        this.perk3Slot2Name = v;
    }

    /**
     * Getter method that gets the image URL of the second perk in tier 3 slot 2.
     * 
     * @return the image URL of the second perk in tier 3 perk slot 2.
     */
    public String getPerk3Slot2Image() {
        return perk3Slot2Image;
    }

    /**
     * Setter method that sets the image URL of the second perk eq in tier 3 slot 2.
     * 
     * @param v the image URL of the second perk in tier 3 perk slot 2 from the database.
     */
    public void setPerk3Slot2Image(String v) {
        this.perk3Slot2Image = v;
    }
 
    /**
     * Getter method that gets the name of the gear equipped in the gear slot.
     * 
     * @return the name of the gear in the gear slot.
     */
    public String getGearName() {
        return gearName;
    }
    
    /**
     * Setter method that sets the name of the gear equipped in the gear slot.
     * 
     * @param v the name of the gear in the gear slot from the .
     */
    public void setGearName(String v) {
        this.gearName = v;
    }
    
    /**
     * Getter method that gets the image URL of the gear equipped in the gear slot.
     * 
     * @return the image URL of the gear in the gear slot.
     */
    public String getGearImage() {
        return gearImage;
    }
    
    /**
     * Setter method that sets the image URL of the gear equipped in the gear slot.
     * 
     * @param v the image URL of the gear in the gear slot from the database.
     */
    public void setGearImage(String v) {
        this.gearImage = v;
    }
    
    /**
     * Getter method that gets the name of the equipment equipped in the equipment slot.
     * 
     * @return the name of the equipment in the equipment slot.
     */
    public String getEquipmentName() {
        return equipmentName;
    }
    
    /**
     * Setter method that sets the name of the equipment equipped in the equipment slot.
     * 
     * @param v the name of the equipment in the equipment slot from the database.
     */
    public void setEquipmentName(String v) {
        this.equipmentName = v;
    }
    
    /**
     * Getter method that gets the image URL of the equipment equipped in the equipment slot.
     * 
     * @return the image URL of the equipment in the equipment slot.
     */
    public String getEquipmentImage() {
        return equipmentImage;
    }
    
    /**
     * Setter method that sets the image URL of the equipment in the equipment slot.
     * 
     * @param v the image URL of the equipment in the equipment slot from the database.
     */
    public void setEquipmentImage(String v) {
        this.equipmentImage = v;
    }
 
    /**
     * Getter method that gets the name of the wildcard equipped in slot 1.
     * 
     * @return the name of the wildcard in slot 1.
     */
    public String getWildcard1Name() {
        return wildcard1Name;
    }
    
    /**
     * Setter method that sets the name of the wildcard equipped in slot 1.
     * 
     * @param v the name of the wildcard in slot 1 from the database.
     */
    public void setWildcard1Name(String v) {
        this.wildcard1Name = v;
    }
    
    /**
     * Getter method that gets the image URL of the wildcard equipped in slot 1.
     * 
     * @return the image URL of the wildcard in slot 1.
     */
    public String getWildcard1Image() {
        return wildcard1Image;
    }
    
    /**
     * Setter method that sets the image URL of the wildcard equipped in slot 1.
     * 
     * @param v the image URL of the wildcard in slot 1 from the database.
     */
    public void setWildcard1Image(String v) {
        this.wildcard1Image = v;
    }
    
    /**
     * Getter method that gets the name of wildcard equipped in slot 2.
     * 
     * @return the name of the wildcard in slot 2.
     */
    public String getWildcard2Name() {
        return wildcard2Name;
    }
    
    /**
     * Setter method the sets the name of the wildcard equipped in slot 2.
     * 
     * @param v the name of the wildcard in slot 2 from the database.
     */
    public void setWildcard2Name(String v) {
        this.wildcard2Name = v;
    }
    
    /**
     * Getter method that gets the image URL of the wildcard equipped in slot 2.
     * 
     * @return the image URL of the wildcard equipped in slot 2.
     */
    public String getWildcard2Image() {
        return wildcard2Image;
    }
    
    /**
     * Setter method that sets the image URL of the wildcard equipped in slot 2.
     * 
     * @param v the image URL of the wildcard equipped in slot 2 from the database.
     */
    public void setWildcard2Image(String v) {
        this.wildcard2Image = v;
    }
    
    /**
     * Getter method that gets the name of the wildcard equipped in slot 3.
     * 
     * @return the name of the wildcard equipped in slot 3.
     */
    public String getWildcard3Name() {
        return wildcard3Name;
    }
    
    /**
     * Setter method that sets the name of the wildcard equipped in slot 3.
     * 
     * @param v the name of the wildcard equipped in slot 3 from the database.
     */
    public void setWildcard3Name(String v) {
        this.wildcard3Name = v;
    }
    
    /**
     * Getter method that gets the image URL of the wildcard equipped in slot 3.
     * 
     * @return the image URL of the wildcard in slot 3.
     */
    public String getWildcard3Image() {
        return wildcard3Image;
    }
    
    /**
     * Setter method the sets the image URL of the wildcard equipped in slot 3.
     * 
     * @param v the image URL of the wildcard in slot 3 from the database.
     */
    public void setWildcard3Image(String v) {
        this.wildcard3Image = v;
    }
}
