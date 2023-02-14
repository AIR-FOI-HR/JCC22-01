package hr.foi.air.core.simulation

import hr.foi.air.core.data.SolutionMaker

class SolutionMakerClass : SolutionMaker {

    override fun makeSolution(a : String) : String {
        var add : String
        if(a == "Početak vožnje"){
            add = "Pokretanje vozila"
        }
        else if(a == "pješak"){
            add = "Zaustavljanje... čekanje prelaska pješaka... nastavak vožnje "
        }
        else if(a == "semafor - crveno svjetlo"){
            add = "Zaustavljanje... čekanje zelenog svjetla... nastavak vožnje"
        }
        else if(a == "lijevi zavoj"){
            add = "Usporavanje... Paljenje lijevog žmigavaca... Skretanje u lijevo... Poravnavanje volana"
        }
        else if(a == "desni zavoj"){
            add = "Usporavanje... Paljenje desnog žmigavaca... Skretanje u desno... Poravnavanje volana"
        }
        else if(a == "Odredište"){
            add = "Stigli ste na traženu lokaciju."
        }
        else{
            add = "pogreška"
        }
        return add
    }
}