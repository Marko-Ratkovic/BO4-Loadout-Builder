package com.bo4loadouts.dao;

import com.bo4loadouts.model.Loadout;
import com.bo4loadouts.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for retrieving loadout data from the bo4_loadouts database.
 * All queries use LEFT JOINs to resolve foreign keys into human-readable names
 * and image paths in a single round-trip per call.
 * 
 * @author Marko
 */
public class LoadoutDAO {
    
    /**
     * Default constructor.
     */
    public LoadoutDAO() {
        
    }
    
    /**
     * Full JOIN query that resolves all foreign keys in the loadouts table into
     * names and image paths in a single database round-trip.
     * Only returns loadouts where is_featured = 1 AND is_public = 1.
     * The WHERE clause is replaced with a simple string substitution in getAllLoadouts().
     */
    private static final String SELECT_FEATURED =
        "SELECT " +
        "  l.id, l.title, l.description, l.pick_10_total, l.view_count, l.like_count, l.is_featured, l.created_at," +

        // Primary weapon
        "  pw.name  AS pw_name,  pw.image_url  AS pw_img,  pwc.name AS pw_cat," +

        // Primary optic
        "  po.name  AS po_name,  po.image_url  AS po_img," +

        // Primary attachments 1–5
        "  pa1.name AS pa1_name, pa1.image_url AS pa1_img," +
        "  pa2.name AS pa2_name, pa2.image_url AS pa2_img," +
        "  pa3.name AS pa3_name, pa3.image_url AS pa3_img," +
        "  pa4.name AS pa4_name, pa4.image_url AS pa4_img," +
        "  pa5.name AS pa5_name, pa5.image_url AS pa5_img," +

        // Secondary weapon
        "  sw.name  AS sw_name,  sw.image_url  AS sw_img,  swc.name AS sw_cat," +

        // Secondary optic
        "  so.name  AS so_name,  so.image_url  AS so_img," +

        // Secondary attachments 1–5
        "  sa1.name AS sa1_name, sa1.image_url AS sa1_img," +
        "  sa2.name AS sa2_name, sa2.image_url AS sa2_img," +
        "  sa3.name AS sa3_name, sa3.image_url AS sa3_img," +
        "  sa4.name AS sa4_name, sa4.image_url AS sa4_img," +
        "  sa5.name AS sa5_name, sa5.image_url AS sa5_img," +

        // Perks  (tier_slot)
        "  p11.name AS p11_name, p11.image_url AS p11_img," +
        "  p12.name AS p12_name, p12.image_url AS p12_img," +
        "  p21.name AS p21_name, p21.image_url AS p21_img," +
        "  p22.name AS p22_name, p22.image_url AS p22_img," +
        "  p31.name AS p31_name, p31.image_url AS p31_img," +
        "  p32.name AS p32_name, p32.image_url AS p32_img," +

        // Gear & Equipment
        "  g.name   AS g_name,   g.image_url   AS g_img," +
        "  e.name   AS e_name,   e.image_url   AS e_img," +

        // Wildcards 1–3
        "  wc1.name AS wc1_name, wc1.image_url AS wc1_img," +
        "  wc2.name AS wc2_name, wc2.image_url AS wc2_img," +
        "  wc3.name AS wc3_name, wc3.image_url AS wc3_img " +

        "FROM loadouts l " +

        // Primary weapon + category
        "LEFT JOIN weapons          pw  ON l.primary_weapon_id      = pw.id  " +
        "LEFT JOIN weapon_categories pwc ON pw.category_id           = pwc.id " +

        // Primary optic
        "LEFT JOIN optics           po  ON l.primary_optic_id        = po.id  " +

        // Primary attachments
        "LEFT JOIN attachments      pa1 ON l.primary_attachment_1    = pa1.id " +
        "LEFT JOIN attachments      pa2 ON l.primary_attachment_2    = pa2.id " +
        "LEFT JOIN attachments      pa3 ON l.primary_attachment_3    = pa3.id " +
        "LEFT JOIN attachments      pa4 ON l.primary_attachment_4    = pa4.id " +
        "LEFT JOIN attachments      pa5 ON l.primary_attachment_5    = pa5.id " +

        // Secondary weapon + category
        "LEFT JOIN weapons          sw  ON l.secondary_weapon_id     = sw.id  " +
        "LEFT JOIN weapon_categories swc ON sw.category_id           = swc.id " +

        // Secondary optic
        "LEFT JOIN optics           so  ON l.secondary_optic_id      = so.id  " +

        // Secondary attachments
        "LEFT JOIN attachments      sa1 ON l.secondary_attachment_1  = sa1.id " +
        "LEFT JOIN attachments      sa2 ON l.secondary_attachment_2  = sa2.id " +
        "LEFT JOIN attachments      sa3 ON l.secondary_attachment_3  = sa3.id " +
        "LEFT JOIN attachments      sa4 ON l.secondary_attachment_4  = sa4.id " +
        "LEFT JOIN attachments      sa5 ON l.secondary_attachment_5  = sa5.id " +

        // Perks
        "LEFT JOIN perks            p11 ON l.perk_1_slot_1           = p11.id " +
        "LEFT JOIN perks            p12 ON l.perk_1_slot_2           = p12.id " +
        "LEFT JOIN perks            p21 ON l.perk_2_slot_1           = p21.id " +
        "LEFT JOIN perks            p22 ON l.perk_2_slot_2           = p22.id " +
        "LEFT JOIN perks            p31 ON l.perk_3_slot_1           = p31.id " +
        "LEFT JOIN perks            p32 ON l.perk_3_slot_2           = p32.id " +

        // Gear & Equipment
        "LEFT JOIN gear             g   ON l.gear_id                 = g.id   " +
        "LEFT JOIN equipment        e   ON l.equipment_id            = e.id   " +

        // Wildcards
        "LEFT JOIN wildcards        wc1 ON l.wildcard_1_id           = wc1.id " +
        "LEFT JOIN wildcards        wc2 ON l.wildcard_2_id           = wc2.id " +
        "LEFT JOIN wildcards        wc3 ON l.wildcard_3_id           = wc3.id " +

        "WHERE l.is_featured = 1 AND l.is_public = 1 " +
        "ORDER BY l.id ASC";

    /**
     * Retrieves all loadouts marked as featured and public.
     * Used to populate the homepage featured section.
     * 
     * @return a list of fully resolved {@link Loadout} objects, never null.
     * @throws SQLException if the database connection or query fails.
     */
    public List<Loadout> getFeaturedLoadouts() throws SQLException {
        List<Loadout> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(SELECT_FEATURED)) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }
        }
        return list;
    }

    /**
     * Retrieves all public loadouts regardless of featured status.
     * Intended for a future browse/all-loadouts page.
     * 
     * @return a list of fully resolved {@link Loadout} objects, never null
     * @throws SQLException if the database connection or query fails.
     */
    public List<Loadout> getAllLoadouts() throws SQLException {
        String sql = SELECT_FEATURED.replace(
            "WHERE l.is_featured = 1 AND l.is_public = 1",
            "WHERE l.is_public = 1");
        List<Loadout> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }
        }
        return list;
    }

    /**
     * Maps a single {@link ResultSet} row to a {@link Loadout} object.
     * Expects the row to contain defined columns from the full join query.
     * 
     * @param rs the current row of the ResultSet, must not be null.
     * @return a populated {@link Loadout} object.
     * @throws SQLException if any column cannot be read.
     */
    private Loadout mapRow(ResultSet rs) throws SQLException {
        Loadout l = new Loadout();

        l.setId(rs.getInt("id"));
        l.setTitle(rs.getString("title"));
        l.setDescription(rs.getString("description"));
        l.setPickTotal(rs.getInt("pick_10_total"));
        l.setViewCount(rs.getInt("view_count"));
        l.setLikeCount(rs.getInt("like_count"));
        l.setFeatured(rs.getBoolean("is_featured"));
        Timestamp ts = rs.getTimestamp("created_at");
        l.setCreatedAt(ts != null ? ts.toString().substring(0, 10) : "");

        // Primary weapon
        l.setPrimaryWeaponName(rs.getString("pw_name"));
        l.setPrimaryWeaponImage(rs.getString("pw_img"));
        l.setPrimaryWeaponCategory(rs.getString("pw_cat"));

        // Primary optic
        l.setPrimaryOpticName(rs.getString("po_name"));
        l.setPrimaryOpticImage(rs.getString("po_img"));

        // Primary attachments
        l.setPrimaryAt1Name(rs.getString("pa1_name"));
        l.setPrimaryAt1Image(rs.getString("pa1_img"));
        
        l.setPrimaryAt2Name(rs.getString("pa2_name"));
        l.setPrimaryAt2Image(rs.getString("pa2_img"));
        
        l.setPrimaryAt3Name(rs.getString("pa3_name"));
        l.setPrimaryAt3Image(rs.getString("pa3_img"));
        
        l.setPrimaryAt4Name(rs.getString("pa4_name"));
        l.setPrimaryAt4Image(rs.getString("pa4_img"));
        
        l.setPrimaryAt5Name(rs.getString("pa5_name"));
        l.setPrimaryAt5Image(rs.getString("pa5_img"));

        // Secondary weapon
        l.setSecondaryWeaponName(rs.getString("sw_name"));
        l.setSecondaryWeaponImage(rs.getString("sw_img"));
        l.setSecondaryWeaponCategory(rs.getString("sw_cat"));

        // Secondary optic
        l.setSecondaryOpticName(rs.getString("so_name"));
        l.setSecondaryOpticImage(rs.getString("so_img"));

        // Secondary attachments
        l.setSecondaryAt1Name(rs.getString("sa1_name"));
        l.setSecondaryAt1Image(rs.getString("sa1_img"));
        
        l.setSecondaryAt2Name(rs.getString("sa2_name"));
        l.setSecondaryAt2Image(rs.getString("sa2_img"));
        
        l.setSecondaryAt3Name(rs.getString("sa3_name"));
        l.setSecondaryAt3Image(rs.getString("sa3_img"));
        
        l.setSecondaryAt4Name(rs.getString("sa4_name"));
        l.setSecondaryAt4Image(rs.getString("sa4_img"));
        
        l.setSecondaryAt5Name(rs.getString("sa5_name"));
        l.setSecondaryAt5Image(rs.getString("sa5_img"));

        // Perks
        l.setPerk1Slot1Name(rs.getString("p11_name"));
        l.setPerk1Slot1Image(rs.getString("p11_img"));
        
        l.setPerk1Slot2Name(rs.getString("p12_name"));
        l.setPerk1Slot2Image(rs.getString("p12_img"));
        
        l.setPerk2Slot1Name(rs.getString("p21_name"));
        l.setPerk2Slot1Image(rs.getString("p21_img"));
        
        l.setPerk2Slot2Name(rs.getString("p22_name"));
        l.setPerk2Slot2Image(rs.getString("p22_img"));
        
        l.setPerk3Slot1Name(rs.getString("p31_name"));
        l.setPerk3Slot1Image(rs.getString("p31_img"));
        
        l.setPerk3Slot2Name(rs.getString("p32_name"));
        l.setPerk3Slot2Image(rs.getString("p32_img"));

        // Gear & Equipment
        l.setGearName(rs.getString("g_name"));  l.setGearImage(rs.getString("g_img"));
        l.setEquipmentName(rs.getString("e_name")); l.setEquipmentImage(rs.getString("e_img"));

        // Wildcards
        l.setWildcard1Name(rs.getString("wc1_name")); l.setWildcard1Image(rs.getString("wc1_img"));
        l.setWildcard2Name(rs.getString("wc2_name")); l.setWildcard2Image(rs.getString("wc2_img"));
        l.setWildcard3Name(rs.getString("wc3_name")); l.setWildcard3Image(rs.getString("wc3_img"));

        return l;
    }
}
