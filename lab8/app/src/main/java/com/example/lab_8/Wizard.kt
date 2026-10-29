
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

    fun restoreMana(amount: Int) { }
}

class WizardTest {
    private val evilWizard = Wizard("Evil Wizard", 30, 10)

    @Test
    fun restoreMana_amountAddedExceedsOneHundred_manaSetToOneHundred() {
        evilWizard.restoreMana(80)
        assertEquals(100, evilWizard.mana)
    }

    @Test
    fun restoreMana_amountAddedDoesNotExceedOneHundred_manaIncreasesCorrectly() {
        evilWizard.restoreMana(40)
        assertEquals(70, evilWizard.mana)
    }
}
