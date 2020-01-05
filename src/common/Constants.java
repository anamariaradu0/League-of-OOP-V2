package common;

public final class Constants {
    private Constants() {
    }

    public static final int ROG_STRATEGY_LOW = 7;
    public static final int ROG_STRATEGY_HIGH = 5;
    public static final int ROG_STRATEGY_DAMAGE = 7;
    public static final int ROG_STRATEGY_ADDHP = 2;
    public static final float ROG_STRATEGY_ADDMOD = 0.4f;
    public static final float ROG_STRATEGY_REMMOD = -0.1f;

    public static final int WIZ_STRATEGY_LOW = 4;
    public static final int WIZ_STRATEGY_HIGH = 2;
    public static final int WIZ_STRATEGY_DAMAGE = 10;
    public static final int WIZ_STRATEGY_ADDHP = 5;
    public static final float WIZ_STRATEGY_ADDMOD = 0.6f;
    public static final float WIZ_STRATEGY_REMMOD = -0.2f;

    public static final int PYR_STRATEGY_LOW = 4;
    public static final int PYR_STRATEGY_HIGH = 3;
    public static final int PYR_STRATEGY_DAMAGE = 4;
    public static final int PYR_STRATEGY_ADDHP = 3;
    public static final float PYR_STRATEGY_ADDMOD = 0.7f;
    public static final float PYR_STRATEGY_REMMOD = -0.3f;

    public static final int KNI_STRATEGY_LOW = 3;
    public static final int KNI_STRATEGY_HIGH = 2;
    public static final int KNI_STRATEGY_DAMAGE = 5;
    public static final int KNI_STRATEGY_ADDHP = 4;
    public static final float KNI_STRATEGY_ADDMOD = 0.5f;
    public static final float KNI_STRATEGY_REMMOD = -0.2f;

    public static final float ROG_DAMAGEANGEL = 0.3f;
    public static final int ROG_DRACULA_DAMAGE = 35;
    public static final float ROG_DRACULA_MOD = 0.10f;
    public static final int ROG_GOODBOY_HP = 40;
    public static final float ROG_GOODBOY_MOD = 0.40f;
    public static final int ROG_SMALLANGEL_HP = 20;
    public static final float ROG_SMALLANGEL_MOD = 0.05f;
    public static final int ROG_LIFEGIVER_HP = 90;
    public static final float ROG_LEVELUP_MOD = 0.15f;
    public static final int ROG_SPAWN_HP = 180;

    public static final float KNI_DAMAGEANGEL = 0.15f;
    public static final int KNI_DRACULA_DAMAGE = 60;
    public static final float KNI_DRACULA_MOD = 0.20f;
    public static final int KNI_GOODBOY_HP = 20;
    public static final float KNI_GOODBOY_MOD = 0.40f;
    public static final int KNI_SMALLANGEL_HP = 10;
    public static final float KNI_SMALLANGEL_MOD = 0.10f;
    public static final int KNI_LIFEGIVER_HP = 100;
    public static final float KNI_LEVELUP_MOD = 0.10f;
    public static final int KNI_SPAWN_HP = 200;

    public static final float WIZ_DAMAGEANGEL = 0.4f;
    public static final int WIZ_DRACULA_DAMAGE = 20;
    public static final float WIZ_DRACULA_MOD = 0.40f;
    public static final int WIZ_GOODBOY_HP = 50;
    public static final float WIZ_GOODBOY_MOD = 0.30f;
    public static final int WIZ_SMALLANGEL_HP = 25;
    public static final float WIZ_SMALLANGEL_MOD = 0.10f;
    public static final int WIZ_LIFEGIVER_HP = 120;
    public static final float WIZ_LEVELUP_MOD = 0.25f;
    public static final int WIZ_SPAWN_HP = 120;

    public static final float PYR_DAMAGEANGEL = 0.2f;
    public static final int PYR_DRACULA_DAMAGE = 40;
    public static final float PYR_DRACULA_MOD = 0.30f;
    public static final int PYR_GOODBOY_HP = 30;
    public static final float PYR_GOODBOY_MOD = 0.50f;
    public static final int PYR_SMALLANGEL_HP = 15;
    public static final float PYR_SMALLANGEL_MOD = 0.15f;
    public static final int PYR_LIFEGIVER_HP = 80;
    public static final float PYR_LEVELUP_MOD = 0.20f;
    public static final int PYR_SPAWN_HP = 150;

    public static final int KNI_DA_DAMAGE = 40;
    public static final int PYR_DA_DAMAGE = 30;
    public static final int ROG_DA_DAMAGE = 10;
    public static final int WIZ_DA_DAMAGE = 20;

    public static final int KNI_XP_ANGEL = 45;
    public static final int PYR_XP_ANGEL = 50;
    public static final int ROG_XP_ANGEL = 40;
    public static final int WIZ_XP_ANGEL = 60;

    public static final int INIT_XP = 0;
    public static final int INIT_LVL = 0;
    public static final int MAX_XP_LIMIT = 200;
    public static final int MAX_XP_MULTIPLIER = 40;
    public static final int MAX_LVL_XP_LIMIT = 250;
    public static final int MAX_LVL_XP_MULTIPLIER = 50;

    public static final int PYR_INIT_HP = 500;
    public static final int PYR_LVL_HP = 50;
    public static final int FIREBLAST_DMG = 350;
    public static final int FIREBLAST_LVL = 50;
    public static final int IGNITE_DMG = 150;
    public static final int IGNITE_LVL = 20;
    public static final int IGNITE_ROUNDS = 2;
    public static final int IGNITE_ROUND_DMG = 50;
    public static final int IGNITE_ROUND_LVL = 30;
    public static final float IGNITE_KNI_BONUS = 0.20f;
    public static final float FIREBLAST_KNI_BONUS = 0.20f;
    public static final float FIREBLAST_PYR_BONUS = 0.1f;
    public static final float IGNITE_PYR_BONUS = 0.1f;
    public static final float FIREBLAST_ROG_BONUS = 0.2f;
    public static final float IGNITE_ROG_BONUS = 0.2f;
    public static final float FIREBLAST_WIZ_BONUS = 0.05f;
    public static final float IGNITE_WIZ_BONUS = 0.05f;
    public static final float PYR_V_BONUS = 0.25f;

    public static final int KNI_INIT_HP = 900;
    public static final int KNI_LVL_HP = 80;
    public static final int EXECUTE_DMG = 200;
    public static final int EXECUTE_LVL = 30;
    public static final float EXECUTE_LIMIT = 0.2f;
    public static final float EXECUTE_PYRO_BONUS = 0.1f;
    public static final float SLAM_PYRO_BONUS = 0.1f;
    public static final float SLAM_ROG_BONUS = 0.2f;
    public static final float EXECUTE_ROG_BONUS = 0.15f;
    public static final float EXECUTE_WIZ_BONUS = 0.2f;
    public static final float SLAM_WIZ_BONUS = 0.05f;
    public static final int EXECUTE_LIMIT_LVL = 1;
    public static final int EXECUTE_LIMIT_MAX = 40;
    public static final int SLAM = 100;
    public static final int SLAM_LVL = 40;
    public static final float SLAM_K_BONUS = 0.20f;
    public static final float KNI_L_BONUS = 0.15f;

    public static final int WIZ_INIT_HP = 400;
    public static final int WIZ_LVL_HP = 30;
    public static final float DRAIN_PERCENT = 0.20f;
    public static final float DRAIN_PERC_LVL = 0.05f;
    public static final float DRAIN_KNI_BONUS = 0.2f;
    public static final float DRAIN_ROG_BONUS = 0.2f;
    public static final float DRAIN_PYR_BONUS = 0.1f;
    public static final float DRAIN_MIN = 0.3f;
    public static final float DEFLECT_PERCENT = 0.35f;
    public static final float DEFLECT_PERC_LVL = 0.02f;
    public static final float DEFLECT_PERC_MAX = 0.7f;
    public static final float DEFLECT_KNI_BONUS = 0.4f;
    public static final float DEFLECT_PYR_BONUS = 0.3f;
    public static final float DEFLECT_ROG_BONUS = 0.2f;
    public static final float DESERT_BONUS = 0.1f;
    public static final float DRAIN_WIZ_BONUS = 0.05f;

    public static final int ROG_INIT_HP = 600;
    public static final int ROG_LVL_HP = 40;
    public static final int BACKSTAB_DMG = 200;
    public static final int BACKSTAB_LVL = 20;
    public static final int BACKSTAB_CRIT = 3;
    public static final float BACKSTAB_K_BONUS = 0.1f;
    public static final float PARALYSIS_K_BONUS = 0.2f;
    public static final float BACKSTAB_WIZ_BONUS = 0.25f;
    public static final float PARALYSIS_WIZ_BONUS = 0.25f;
    public static final float PARALYSIS_ROG_BONUS = 0.1f;
    public static final float PARALYSIS_PYR_BONUS = 0.2f;
    public static final float BACKSTAB_PYR_BONUS = 0.25f;
    public static final float BACKSTAB_ROG_BONUS = 0.2f;
    public static final float BACKSTAB_MULTIPLIER = 1.5f;
    public static final int PARALYSIS_DMG = 40;
    public static final int PARALYSIS_LVL = 10;
    public static final int PARALYSIS_ROUNDS = 3;
    public static final int PARALYSIS_WOODS = 6;
    public static final float ROG_W_BONUS = 0.15f;

    public static final float APPROX = 0.0000001f;
    public static final float APPROXIMATE = 0.0000002f;

    public static final int MAX_MAP = 20;
}
