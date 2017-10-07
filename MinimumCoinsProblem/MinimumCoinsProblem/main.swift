//
//  main.swift
//  MinimumCoinsProblem
//
//  Created by Marius Ilie on 07/10/2017.
//  Copyright © 2017 Marius Ilie - G. 243. All rights reserved.
//

import Foundation

//CITIRE DATE
let coins = ExchangeConsole.readCoins()
let moneySum = ExchangeConsole.readMoneySum()

//REZULTAT
let result = Exchanger(withCoins: coins).changeMoney(moneySum)
ExchangeConsole.printResult(result)
