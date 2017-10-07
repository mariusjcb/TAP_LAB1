//
//  ExchangeConsole.swift
//  MinimumCoinsProblem
//
//  Created by Marius Ilie on 07/10/2017.
//  Copyright © 2017 Marius Ilie - G. 243. All rights reserved.
//

import Foundation

class ExchangeConsole {
    private init() { }
    
    //MARK: - Validators
    
    private class func hasValidCoins(_ coins: [Int]?) -> Bool {
        return coins?.isEmpty == false
    }
    
    private class func hasValidSum(_ sum: String?) -> Bool {
        guard sum != nil, let validSum = Int(sum!) else {
            return false
        }
        
        return validSum > 0
    }
    
    //MARK: - Readers
    
    class func readCoins() -> [Int] {
        print(DefaultStrings.coins + ":")
        let coins = readLine()?.extractIntegers()
        
        if !hasValidCoins(coins) {
            print(DefaultStrings.invalidCoins)
            return readCoins()
        }
        
        return coins!
    }
    
    class func readMoneySum() -> Int {
        print(DefaultStrings.exchangeSum + ":")
        let money = readLine()
        
        if !hasValidSum(money) {
            print(DefaultStrings.invalidExchangeSum)
            return readMoneySum()
        }
        
        return Int(money!)!
    }
    
    //MARK: - Printers
    
    class func printResult(_ result: [Int]?, format: String = DefaultStrings.exchangeFormat) {
        print(DefaultStrings.exchangeResult + ":")
        
        guard let result = result else {
            print(DefaultStrings.noExchangeResult)
            return
        }
        
        let occurrences = Counter.countOccurrences(in: result)
        for (value, count) in occurrences {
            let exchangeValue = String(format: format, value, DefaultStrings.exchangeUnit)
            print(count, "x", exchangeValue)
        }
    }
}
