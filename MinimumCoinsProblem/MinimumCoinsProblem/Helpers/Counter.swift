//
//  Counter.swift
//  MinimumCoinsProblem
//
//  Created by Marius Ilie on 07/10/2017.
//  Copyright © 2017 Marius Ilie - G. 243. All rights reserved.
//

import Foundation

class Counter {
    private init() { }
    
    class func countOccurrences<T>(in array: [T]) -> [T: Int] {
        var counts: [T: Int] = [:]
        array.forEach { counts[$0, default: 0] += 1 }
        
        return counts
    }
}
