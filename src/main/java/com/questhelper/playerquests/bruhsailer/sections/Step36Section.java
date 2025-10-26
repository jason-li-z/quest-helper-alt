package com.questhelper.playerquests.bruhsailer.sections;

import com.questhelper.questhelpers.PlayerMadeQuestHelper;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.runelite.PlayerQuestStateRequirement;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.DetailedQuestStep;
import net.runelite.api.gameval.ItemID;

import java.util.Arrays;

public class Step36Section extends PlayerMadeQuestSection
{
    // Item Requirements
    private ItemRequirement desertClothes, varrockTeleport, smallFishingNet, coins, food, barcrawlCard, seaweed, snakeWeed, ardrigal, volenciaMoss, roguesPurse, charcoal, antipoison, karambwanji, camelotTeleport, windStrikes, spade, steelAxe, softClay;

    // Steps
    private DetailedQuestStep grabSupplies, charterToBrimhaven, doJunglePotion, buySupplies, startTaiBwoWannaiTrio, fishKarambwanji, teleportToVarrock, grabBankSupplies;

    public Step36Section(PlayerMadeQuestHelper questHelper)
    {
        super(questHelper);
        setupRequirements();
        setupSteps();
    }

    private void setupRequirements()
    {
        desertClothes = new ItemRequirement("Desert clothes", ItemID.DESERT_SHIRT).isNotConsumed();
        varrockTeleport = new ItemRequirement("Varrock teleport", ItemID.VARROCK_TELEPORT, 1);
        smallFishingNet = new ItemRequirement("Small fishing net", ItemID.SMALL_FISHING_NET).isNotConsumed();
        coins = new ItemRequirement("Coins", ItemID.COINS, 4840);
        food = new ItemRequirement("Food", ItemID.CAKE, 5);
        barcrawlCard = new ItemRequirement("Barcrawl card", ItemID.BARCRAWL_CARD).isNotConsumed();
        seaweed = new ItemRequirement("Seaweed", ItemID.SEAWEED, 1);
        snakeWeed = new ItemRequirement("Snake weed", ItemID.SNAKE_WEED, 3);
        ardrigal = new ItemRequirement("Ardrigal", ItemID.ARDRIGAL, 3);
        volenciaMoss = new ItemRequirement("Volencia moss", ItemID.VOLENCIA_MOSS, 1);
        roguesPurse = new ItemRequirement("Rogue's purse", ItemID.ROGUES_PURSE, 1);
        charcoal = new ItemRequirement("Charcoal", ItemID.CHARCOAL, 7);
        antipoison = new ItemRequirement("Antipoison", ItemID.ANTIPOISON4, 5);
        karambwanji = new ItemRequirement("Karambwanji", ItemID.KARAMBWANJI, 23);
        camelotTeleport = new ItemRequirement("Camelot teleport", ItemID.CAMELOT_TELEPORT, 1);
        windStrikes = new ItemRequirement("Wind strikes", ItemID.MIND_RUNE, 1).isNotConsumed();
        spade = new ItemRequirement("Spade", ItemID.SPADE).isNotConsumed();
        steelAxe = new ItemRequirement("Steel axe", ItemID.STEEL_AXE).isNotConsumed();
        softClay = new ItemRequirement("Soft clay", ItemID.SOFT_CLAY, 4);
    }

    @Override
    protected void setupSteps()
    {
        grabSupplies = new DetailedQuestStep(questHelper,
            "[36.0] Grab desert clothes, Varrock teleport runes, a small fishing net, coins, some (3-5 cakes, drop excess later) food and the barcrawl card from the bank.");

        charterToBrimhaven = new DetailedQuestStep(questHelper,
            "[36.1] Charter a ship to Brimhaven, visit Dead Man’s Chest for the barcrawl, run south and pick up a seaweed and drop it 5 times (west of Jiminua’s shop) for the diary, keep it for later.");

        doJunglePotion = new DetailedQuestStep(questHelper,
            "[36.2] Do Jungle Potion. During the quest collect 3 extra snake weed, 3 extra ardrigal, 1 extra volencia moss and 1 extra rogue’s purse.");

        buySupplies = new DetailedQuestStep(questHelper,
            "[36.3] Go to the shop and buy 7 charcoal and 5 antipoisons.");

        startTaiBwoWannaiTrio = new DetailedQuestStep(questHelper,
            "[36.4] Start Tai Bwo Wannai Trio.");

        fishKarambwanji = new DetailedQuestStep(questHelper,
            "[36.5] Run south and fish at least 23 karambwanji (it is recommended to collect several hundred extra for growing cats).");

        teleportToVarrock = new DetailedQuestStep(questHelper,
            "[36.6] Teleport to Varrock.");

        grabBankSupplies = new DetailedQuestStep(questHelper,
            "[36.7] Run to the bank, grab coins, home and camelot teleport runes (air, earth, law), wind strikes, a spade, a steel axe and four soft clay (unnoted).");
    }

    @Override
    public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
    {
        flow.addStep(state.getNewState(367), grabBankSupplies);
        flow.addStep(state.getNewState(366), teleportToVarrock);
        flow.addStep(state.getNewState(365), fishKarambwanji);
        flow.addStep(state.getNewState(364), startTaiBwoWannaiTrio);
        flow.addStep(state.getNewState(363), buySupplies);
        flow.addStep(state.getNewState(362), doJunglePotion);
        flow.addStep(state.getNewState(361), charterToBrimhaven);
        flow.addStep(state.getNewState(360), grabSupplies);
    }

    @Override
    public DetailedQuestStep getDefaultStep()
    {
        return grabSupplies;
    }

    @Override
    public com.questhelper.panel.PanelDetails getPanel()
    {
        return new com.questhelper.panel.PanelDetails("Step 36 — Brimhaven & Tai Bwo Wannai", Arrays.asList(
            grabSupplies, charterToBrimhaven, doJunglePotion, buySupplies, startTaiBwoWannaiTrio, fishKarambwanji, teleportToVarrock, grabBankSupplies
        ), desertClothes, varrockTeleport, smallFishingNet, coins, food, barcrawlCard, seaweed, snakeWeed, ardrigal, volenciaMoss, roguesPurse, charcoal, antipoison, karambwanji, camelotTeleport, windStrikes, spade, steelAxe, softClay);
    }
}