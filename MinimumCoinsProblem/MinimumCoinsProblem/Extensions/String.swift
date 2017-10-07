//
//  Console.swift
//  MinimumCoinsProblem
//
//  Created by Marius Ilie on 07/10/2017.
//  Copyright © 2017 Marius Ilie - G. 243. All rights reserved.
//

import Foundation

extension String {
    func split(withRegex pattern: String) -> [String] {
        let regex = try! NSRegularExpression(pattern: pattern, options: [])
        
        let range = NSMakeRange(0, self.characters.count)
        let matches = regex.matches(in: self, options: [], range: range)
            
        return matches.map({
            guard let range = Range($0.range, in: self) else {
                return ""
            }
            
            return String(self[range])
        }).filter {
            $0.isEmpty == false
        }
    }
    
    func extractIntegers() -> [Int] {
        var resultIntegers = [Int]()
        let regexMatches = self.split(withRegex: "(\\d+)")
        
        for match in regexMatches {
            guard let matchValue = Int(match) else {
                continue
            }
            
            resultIntegers.append(matchValue)
        }
        
        return resultIntegers
    }
}
