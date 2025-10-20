package com.questhelper.playerquests.bruhsailer.sections;

import com.questhelper.panel.PanelDetails;
import com.questhelper.playerquests.bruhsailer.BruhsailerGuide;
import com.questhelper.requirements.runelite.PlayerQuestStateRequirement;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.ObjectStep;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.ObjectID;

import java.util.Arrays;

public class Step22Section
{
    private final BruhsailerGuide quest;

    private NpcStep buyStavesZaff;
    private DetailedQuestStep bankFaladorGlassKit, reginusToVarlamore, continueEAAUntilPortSarim,
            completePiratesTreasure, bankForBulkMats,
            killBearSafespot, completeGoblinDiplomacy, completeWitchsHouse, completeDruidicRitual,
            buyFromJatix, feroxRestoreAndBank;
    private NpcStep talkSirRenitee, killDuckMagic, startDoricsQuest, startBelowIceMountain, startFishingContest;
    private ObjectStep faladorPortraitCupboard, makeMoltenGlass;

    public Step22Section(BruhsailerGuide quest)
    {
        this.quest = quest;
        setupSteps();
    }

    private void setupSteps()
    {
        buyStavesZaff = new NpcStep(quest, NpcID.ZAFF, new WorldPoint(3202, 3434, 0),
                "[22.1] Use Chronicle to Varrock. Buy one of each elemental staff from Zaff.");
        buyStavesZaff.addDialogStep("Do you have anything to trade?");

        bankFaladorGlassKit = new DetailedQuestStep(quest,
                "[22.2] Bank: withdraw 7 soda ash, 7 buckets of sand, a spade, leather gloves, Wind Strike runes (wind staff + 1200 mind runes), and a Falador tab.");

        reginusToVarlamore = new DetailedQuestStep(quest, new WorldPoint(1701, 3143, 0),
                "[22.3] Take the quetzal to Varlamore (Regulus Cento south of Varrock Museum). Start Ethically Acquired Antiquities.");

        continueEAAUntilPortSarim = new DetailedQuestStep(quest,
                "[22.3] Continue Ethically Acquired Antiquities until told to visit Port Sarim (then pause EAA).");

        faladorPortraitCupboard = new ObjectStep(quest, ObjectID.VYVINCUPBOARDOPEN, new WorldPoint(2985, 3336, 2),
                "[22.4] Break Falador tab. In Falador Castle (2F), search the cupboard south of the staircase for the portrait.");
        ((ObjectStep) faladorPortraitCupboard).addAlternateObjects(ObjectID.VYVINCUPBOARDSHUT);

        talkSirRenitee = new NpcStep(quest, NpcID.POH_HERALD_OF_FALADOR, new WorldPoint(2982, 3341, 1),
                "[22.5] Speak with Sir Renitee upstairs in White Knights' Castle for the diary.");

        makeMoltenGlass = new ObjectStep(quest, ObjectID.FAI_FALADOR_FURNACE, new WorldPoint(2976, 3369, 0),
                "[22.6] Turn the 7 soda ash and 7 sand into molten glass at a furnace.");

        killDuckMagic = new NpcStep(quest, NpcID.DUCK_FEMALE, new WorldPoint(2989, 3379, 0),
                "[22.7] Kill a duck in Falador Park using Wind Strike.");
        ((NpcStep) killDuckMagic).addAlternateNpcs(NpcID.DUCK);

        completePiratesTreasure = new DetailedQuestStep(quest,
                "[22.8] Complete Pirate's Treasure using the quest helper.");

        bankForBulkMats = new DetailedQuestStep(quest,
                "[22.9] Bank then withdraw: raw beef, chicken and rat meat; orange + blue dye (or red+yellow to make orange); 2 iron ore, 4 copper ore, 6 clay, 2 cheese (optionally swap one cheese for an extra cake/wine for Witch's House), gp stack and 3+ cakes/wines; pickaxe.");

        startDoricsQuest = new NpcStep(quest, NpcID.DORIC, new WorldPoint(2951, 3451, 0),
                "[22.10] Run north and speak to Doric to start/complete Doric's Quest using the quest helper.");

        startBelowIceMountain = new NpcStep(quest, NpcID.BIM_WILLOW, new WorldPoint(3003, 3435, 0),
                "[22.11] Start Below Ice Mountain by speaking to Willow south of Ice Mountain.");

        killBearSafespot = new DetailedQuestStep(quest, new WorldPoint(2960, 3435, 0),
                "[22.12] Safespot a bear on the trees north of Falador for meat, fur, and ribs.");

        completeGoblinDiplomacy = new DetailedQuestStep(quest, "[22.13] Complete Goblin Diplomacy using the quest helper.");
        completeWitchsHouse = new DetailedQuestStep(quest, "[22.13] Complete Witch's House (safespots exist for all forms). Use the quest helper.");
        completeDruidicRitual = new DetailedQuestStep(quest, "[22.13] Complete Druidic Ritual using the quest helper.");

        buyFromJatix = new DetailedQuestStep(quest, new WorldPoint(2926, 3439, 0),
                "[22.14] Buy an eye of newt pack, a single empty vial, and a pestle and mortar from Jatix in Taverley.");

        startFishingContest = new NpcStep(quest, NpcID.BONZO, new WorldPoint(2641, 3437, 0),
                "[22.15] Start Fishing Contest by speaking to Bonzo in Hemenster.");

        feroxRestoreAndBank = new DetailedQuestStep(quest,
                "[22.16] Minigame teleport to Clan Wars (Ferox), restore energy, bank, then withdraw: 2 iron bars, a POH tab, the portrait, 3-5 cakes and a pickaxe.");
    }

    public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
    {
        flow.addStep(state.getNewState(259), feroxRestoreAndBank); feroxRestoreAndBank.withId(259);
        flow.addStep(state.getNewState(258), startFishingContest); startFishingContest.withId(258);
        flow.addStep(state.getNewState(257), buyFromJatix); buyFromJatix.withId(257);
        flow.addStep(state.getNewState(256), completeDruidicRitual); completeDruidicRitual.withId(256);
        flow.addStep(state.getNewState(255), completeWitchsHouse); completeWitchsHouse.withId(255);
        flow.addStep(state.getNewState(254), completeGoblinDiplomacy); completeGoblinDiplomacy.withId(254);
        flow.addStep(state.getNewState(253), killBearSafespot); killBearSafespot.withId(253);
        flow.addStep(state.getNewState(252), startBelowIceMountain); startBelowIceMountain.withId(252);
        flow.addStep(state.getNewState(251), startDoricsQuest); startDoricsQuest.withId(251);
        flow.addStep(state.getNewState(250), bankForBulkMats); bankForBulkMats.withId(250);
        flow.addStep(state.getNewState(249), completePiratesTreasure); completePiratesTreasure.withId(249);
        flow.addStep(state.getNewState(248), killDuckMagic); killDuckMagic.withId(248);
        flow.addStep(state.getNewState(247), makeMoltenGlass); makeMoltenGlass.withId(247);
        flow.addStep(state.getNewState(246), talkSirRenitee); talkSirRenitee.withId(246);
        flow.addStep(state.getNewState(245), faladorPortraitCupboard); faladorPortraitCupboard.withId(245);
        flow.addStep(state.getNewState(244), continueEAAUntilPortSarim); continueEAAUntilPortSarim.withId(244);
        flow.addStep(state.getNewState(243), reginusToVarlamore); reginusToVarlamore.withId(243);
        flow.addStep(state.getNewState(242), bankFaladorGlassKit); bankFaladorGlassKit.withId(242);
        flow.addStep(state.getNewState(241), buyStavesZaff); buyStavesZaff.withId(241);
    }

    public PanelDetails getPanel()
    {
        return new PanelDetails("Step 22 - Varrock + Varlamore + Falador", Arrays.asList(
                buyStavesZaff, bankFaladorGlassKit, reginusToVarlamore, continueEAAUntilPortSarim, faladorPortraitCupboard, talkSirRenitee, makeMoltenGlass, killDuckMagic, completePiratesTreasure,
                bankForBulkMats, startDoricsQuest, startBelowIceMountain, killBearSafespot, completeGoblinDiplomacy, completeWitchsHouse, completeDruidicRitual, buyFromJatix, startFishingContest, feroxRestoreAndBank
        ));
    }
}

