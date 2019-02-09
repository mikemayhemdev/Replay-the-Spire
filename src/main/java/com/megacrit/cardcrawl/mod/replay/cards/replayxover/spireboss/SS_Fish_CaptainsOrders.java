package com.megacrit.cardcrawl.mod.replay.cards.replayxover.spireboss;

import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.mod.replay.powers.PondfishDrowning;

import slimebound.*;
import slimebound.powers.PotencyPower;

import com.megacrit.cardcrawl.characters.*;
import com.megacrit.cardcrawl.monsters.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.actions.animations.*;
import com.megacrit.cardcrawl.vfx.*;

import basemod.abstracts.CustomCard;
import replayTheSpire.replayxover.slimeboundbs;

import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.powers.*;
import java.util.*;
import com.megacrit.cardcrawl.core.*;

public class SS_Fish_CaptainsOrders extends CustomCard
{
    public static final String ID = "Replay:SS_fish_4";
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final CardStrings cardStrings;
    private static final int COST = 0;
    
    public SS_Fish_CaptainsOrders() {
        super(ID, SS_Fish_CaptainsOrders.NAME, "cards/replay/ss_fish_orders.png", COST, SS_Fish_CaptainsOrders.DESCRIPTION, AbstractCard.CardType.POWER, AbstractCard.CardColor.COLORLESS, AbstractCard.CardRarity.SPECIAL, AbstractCard.CardTarget.SELF);
        this.tags.add(slimeboundbs.STUDY_PONDFISH);
        this.tags.add(SlimeboundMod.STUDY);
        this.magicNumber = this.baseMagicNumber = 1;
        this.block = this.baseBlock = 10;
    }
    
    public void use(final AbstractPlayer p, final AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
        if (!p.hasPower(StrengthPower.POWER_ID) || p.getPower(StrengthPower.POWER_ID).amount < 1) {
        	AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StrengthPower(p, 1), 1));
        }
        if (!p.hasPower(PotencyPower.POWER_ID) || p.getPower(PotencyPower.POWER_ID).amount < 1) {
        	AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new PotencyPower(p, p, 1), 1));
        }
    }
    
    public AbstractCard makeCopy() {
        return new SS_Fish_CaptainsOrders();
    }
    
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(5);
        }
    }
    
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = SS_Fish_CaptainsOrders.cardStrings.NAME;
        DESCRIPTION = SS_Fish_CaptainsOrders.cardStrings.DESCRIPTION;
    }
}
