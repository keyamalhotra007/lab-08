
package com.example.lab_8

import org.junit.Test
import kotlin.test.assertEquals

//test comment
class Wizard(val name: String, var mana: Int, var spellPower: Int) {
    fun castSpell(spell: String): Int {
        when (spell) {
            "Explosion" -> {
                if (mana >= 10) {
                    mana -= 10
                    return spellPower * 3
                } else return 0
            }
            "Frostbite" -> {
                if (mana >= 5) {
                    mana -= 5
                    return spellPower * 2
                } else return 0
            }
            else -> {
                return 0
            }
        }
    }

    fun restoreMana(amount: Int) {
        mana = minOf(100, mana + amount)
    }

    fun train() {

    }
}

class WizardTest {


    @Test
    fun restoreMana_amountAddedExceedsOneHundred_manaSetToOneHundred() {
        val evilWizard = Wizard("Evil Wizard", 30, 10)
        evilWizard.restoreMana(80)
        assertEquals(100, evilWizard.mana)
    }

    @Test
    fun restoreMana_amountAddedDoesNotExceedOneHundred_manaIncreasesCorrectly() {
        val evilWizard = Wizard("Evil Wizard", 30, 10)
        evilWizard.restoreMana(40)
        assertEquals(70, evilWizard.mana)
    }

    @Test
    fun train_haveEnoughMana(){
        val evilWizard = Wizard("Evil Wizard", 30, 10)
        evilWizard.train()
        assertEquals(25, evilWizard.mana)
        assertEquals(9, evilWizard.spellPower)
    }

    @Test
    fun train_notEnoughMana(){
        val otherWizard = Wizard("Other Wizard", 4, 10)
        otherWizard.train()
        assertEquals(4, otherWizard.mana)
        assertEquals(10, otherWizard.spellPower)


    }

}
