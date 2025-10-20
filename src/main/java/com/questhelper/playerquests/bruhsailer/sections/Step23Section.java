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

public class Step23Section
{
    private final BruhsailerGuide quest;

    private DetailedQuestStep thurgoPohTab, faladorEastBankGrab, completeKnightsSword;
    private ObjectStep mineBluriteTwo, smeltBluriteBar;
    private NpcStep makeSwordThurgo, eaaCrewmemberPortSarim, eaaTalkBetty, moveHousePollnivneach;

    public Step23Section(BruhsailerGuide quest)
    {
        this.quest = quest;
        setupSteps();
    }

    private void setupSteps()
    {
        thurgoPohTab = new DetailedQuestStep(quest, new WorldPoint(3000, 3145, 0),
                "[23.1] Break another POH tab; run to Thurgo south of Port Sarim.");

        mineBluriteTwo = new ObjectStep(quest, ObjectID.BLURITE_ROCK_1, new WorldPoint(3049, 9566, 0),
                "[23.2] Enter the dungeon south of Port Sarim and mine two blurite ore.");

        makeSwordThurgo = new NpcStep(quest, NpcID.THURGO, new WorldPoint(3000, 3145, 0),
                "[23.3] Return to Thurgo with 2 iron bars and make the sword.");

        eaaCrewmemberPortSarim = new NpcStep(quest, NpcID.SAILING_TRANSPORT_TRADER_STAN_BASE, new WorldPoint(3036, 3194, 0),
                "[23.4] Speak to Trader Stan (southern deck) in Port Sarim for Ethically Acquired Antiquities.");

        eaaTalkBetty = new NpcStep(quest, NpcID.SARIM_BETTY, new WorldPoint(3011, 3260, 0),
                "[23.5] Talk to Betty at the Rune shop to progress Ethically Acquired Antiquities.");

        faladorEastBankGrab = new DetailedQuestStep(quest, new WorldPoint(3013, 3353, 0),
                "[23.6] Run to Falador east bank; withdraw coins (7,500 gp), Ghostspeak amulet, and the Ghost's skull.");

        moveHousePollnivneach = new NpcStep(quest, NpcID.POH_ESTATE_AGENT, new WorldPoint(3240, 3475, 0),
                "[23.7] Speak to an Estate Agent and pay to move your house to Pollnivneach.");

        completeKnightsSword = new DetailedQuestStep(quest, "[23.8] Complete The Knight's Sword using the quest helper.");

        smeltBluriteBar = new ObjectStep(quest, ObjectID.FAI_FALADOR_FURNACE, new WorldPoint(2976, 3369, 0),
                "[23.9] Smelt a blurite ore into a bar at a furnace.");
    }

    public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
    {
        flow.addStep(state.getNewState(239), smeltBluriteBar); smeltBluriteBar.withId(239);
        flow.addStep(state.getNewState(238), completeKnightsSword); completeKnightsSword.withId(238);
        flow.addStep(state.getNewState(237), moveHousePollnivneach); moveHousePollnivneach.withId(237);
        flow.addStep(state.getNewState(236), faladorEastBankGrab); faladorEastBankGrab.withId(236);
        flow.addStep(state.getNewState(235), eaaTalkBetty); eaaTalkBetty.withId(235);
        flow.addStep(state.getNewState(234), eaaCrewmemberPortSarim); eaaCrewmemberPortSarim.withId(234);
        flow.addStep(state.getNewState(233), makeSwordThurgo); makeSwordThurgo.withId(233);
        flow.addStep(state.getNewState(232), mineBluriteTwo); mineBluriteTwo.withId(232);
        flow.addStep(state.getNewState(231), thurgoPohTab); thurgoPohTab.withId(231);
    }

    public PanelDetails getPanel()
    {
        return new PanelDetails("Step 23 - Thurgo, EAA, Falador", Arrays.asList(
                thurgoPohTab, mineBluriteTwo, makeSwordThurgo, eaaCrewmemberPortSarim, eaaTalkBetty, faladorEastBankGrab, moveHousePollnivneach, completeKnightsSword, smeltBluriteBar
        ));
    }
}

