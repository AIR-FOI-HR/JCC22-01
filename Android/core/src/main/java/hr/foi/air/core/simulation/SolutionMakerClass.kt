package hr.foi.air.core.simulation

import hr.foi.air.core.data.SolutionMaker

class SolutionMakerClass : SolutionMaker {

    override fun makeSolution(a : String) : String {
        var add : String
        if(a == "pjesak"){
            add = "zaustavi se, pricekaj da prijede i onda nastavi "
        }
        else if(a == "semafor"){
            add = "zaustavi se, pricekaj zeleno i onda nastavi"
        }
        else if(a == "lijevi zavoj"){
            add = "uspori, daj lijevi zmigavac i skreni lijevo"
        }
        else if(a == "desni zavoj"){
            add = "uspori, daj desni zmigavac i skreni desno"
        }
        else{
            add = "pogreska"
        }
        return add
    }
}