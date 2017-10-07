//
//  main.swift
//  MinimumCoinsProblem
//
//  Created by Marius Ilie on 07/10/2017.
//  Copyright © 2017 Marius Ilie - G. 243. All rights reserved.
//

import Foundation

//MONEDE
let coins = [1, 10, 2, 20, 25]

//SUMA TOTALA
let moneySum = 41

//REZULTAT
let result = Exchanger(withCoins: coins).changeMoney(moneySum)

print(result ?? "Suma nu se poate imparti in monedele de schimb")
