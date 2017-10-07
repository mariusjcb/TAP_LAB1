//
//  Exchange.swift
//  
//
//  Created by Marius Ilie on 07/10/2017.
//

import Foundation

class Exchanger {
    private(set) var coins: [Int]! {
        didSet {
            // FILTREZ PENTRU A ELIMINA MONEDELE INVALIDE ( <= 0 )
            // SORTEZ DESC
            coins = coins?.filter({ $0 > 0 }).sorted(by: { $0 > $1 })
        }
    }
    
    init(withCoins coins: [Int]) {
        self.coins = coins
    }
    
    func changeMoney(_ money: Int) -> [Int]? {
        // VERIFIC SUMA > 0
        guard money > 0 else {
            return []
        }
        
        var storedResults: [Int : [Int]] = [:]
        
        func getPotentialResult(for value: Int) -> [Int] {
            guard value > 0 else {
                return []
            }
            
            // PREVIN LOOP PRIN SALVAREA POTENTIALELOR REZULTATE + VERIF.
            if let result = storedResults[value] {
                return result
            }
            
            var potentialResults: [[Int]] = []
            for coin in coins {
                if value - coin >= 0 {
                    var potentialChange: [Int] = [coin]
                    
                    // CAUT DUPA DIF.
                    potentialChange.append(contentsOf: getPotentialResult(for: value - coin))
                    
                    // REDUCE FACE SUMA TUTUROR EL.
                    if potentialChange.reduce(0, +) == value {
                        potentialResults.append(potentialChange)
                    }
                }
            }
            
            if potentialResults.count > 0 {
                // RES. CU CELE MAI PUTINE NR. E CORECT
                storedResults[value] = potentialResults.sorted(by: { $0.count < $1.count })[0]
                return storedResults[value] ?? []
            }
            
            return []
        }
        
        let change: [Int] = getPotentialResult(for: money)
        
        // REDUCE FACE SUMA TUTUROR EL.
        if change.reduce(0, +) != money {
            return nil
        }
        
        return change
    }
}
