# Robotic Automation Factory

This project implements a package sorting function for a robotic automation system. The goal is to classify each package based on its dimensions and mass so it can be routed to the correct dispatch lane.

## Problem Statement

A factory needs to automatically sort packages into one of three categories:

- `STANDARD`
- `SPECIAL`
- `REJECTED`

The classification depends on whether a package is `bulky`, `heavy`, or both.

### Input

The sorting function receives:

- `width` in centimeters
- `height` in centimeters
- `length` in centimeters
- `mass` in kilograms

### Rules

A package is considered `bulky` if:

- its volume is greater than or equal to `1,000,000 cm^3`, or
- any one dimension is greater than or equal to `150 cm`

A package is considered `heavy` if:

- its mass is greater than or equal to `20 kg`

### Output

Return:

- `REJECTED` if the package is both `bulky` and `heavy`
- `SPECIAL` if the package is either `bulky` or `heavy`
- `STANDARD` if the package is neither `bulky` nor `heavy`

## Given Solution

The repository currently includes a Java implementation in [SortPackages.java](/c:/Users/Akshat%20Agarwal/Desktop/robotic-automation-factory/SortPackages.java).

```java
public class SortPackages {

    public static String sort(int width, int height, int length, int mass) {
        int volume = width * height * length;
        boolean isBulky = volume >= 1_000_000 || width >= 150 || height >= 150 || length >= 150;
        boolean isHeavy = mass >= 20;
        if (isBulky && isHeavy)
            return "REJECTED";
        if (isBulky || isHeavy)
            return "SPECIAL";
        return "STANDARD";
    }

    public static void main(String[] args) {
        System.out.println(sort(10, 10, 10, 5));
        System.out.println(sort(200, 10, 10, 5));
        System.out.println(sort(10, 10, 10, 25));
        System.out.println(sort(200, 200, 200, 25));
    }
}
```

## How the Solution Works

The function follows these steps:

1. Calculate package volume using `width * height * length`.
2. Check whether the package is `bulky`.
3. Check whether the package is `heavy`.
4. Apply the classification rules in priority order:
   - both bulky and heavy -> `REJECTED`
   - one of them -> `SPECIAL`
   - neither -> `STANDARD`

## Example Cases

| Width | Height | Length | Mass | Result |
|------:|-------:|-------:|-----:|--------|
| 10 | 10 | 10 | 5 | `STANDARD` |
| 200 | 10 | 10 | 5 | `SPECIAL` |
| 10 | 10 | 10 | 25 | `SPECIAL` |
| 200 | 200 | 200 | 25 | `REJECTED` |

## Run the Java Program

Compile:

```powershell
javac SortPackages.java
```

Run:

```powershell
java SortPackages
```



## Notes

- The current implementation uses `int` for dimensions, mass, and volume.
- For very large dimension values, using `long` for volume would be safer to avoid integer overflow.
