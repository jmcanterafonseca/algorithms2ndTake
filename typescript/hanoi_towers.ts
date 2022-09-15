/**
Solves the problem of Hanoi towers 
Three Towers: one of the towers contains 
a stack of disks in ascending order from top to bottom
It is needed to move the disks from Tower 1 to Tower 3
respecting the restriction that a disk can only be on top of another
disk of greater size 
Disks are labelled by their size which can be 1..n
Towers are labelled as 1,2,3
*/

// Represents a Tower that internally has a stack to pile disks
class Tower {
    // Index of tower (1, 2, 3)
    constructor(index: number) {
        this.index = index;
    }
    // The index of the tower
    public index: number;

    // The stack with the disks
    private disks: number[] = [];

    // Adds the disk to the tower
    public addDisk(diskSize: number | undefined): void {
        if (diskSize === undefined) {
            throw new Error("Undefined disk size");
        }
        // Check that it can pilled
        if (this.disks[0] < diskSize) {
            throw new Error(`Cannot pile ${diskSize} on ${this.disks[0]}`);
        }
        this.disks.push(diskSize);
    }

    /** Pops the disk on the top and returns the disk label */
    public removeDisk(): number | undefined {
        return this.disks.pop();
    }

    public moveAllTo(destTower: Tower, bufferTower: Tower): void {
        this.moveDisks(this.disks.length, destTower, bufferTower);
    }

    public numDisks(): number {
        return this.disks.length;
    }

    private moveDisks(n: number, destTower: Tower, bufferTower: Tower) {
        if (n > 0) {
            // Move all but last one to the buffer tower using the dest as intermmediate buffer
            this.moveDisks(n - 1, bufferTower, destTower);

            // Top is moved to the dest Tower
            const top = this.removeDisk();
            destTower.addDisk(top);

            // Move all last one from the buffer tower to the dest tower using the origin as intermmediate buffer
            bufferTower.moveDisks(n - 1, destTower, this);
        }
    }
}

function main() {
    const towers: Tower[] = [];

    // We have three towers
    for (let i = 0; i < 3; i++) {
        towers[i] = new Tower(i + 1);
    }

    // 6 disks are pilled in the origin tower
    const NUM_DISKS = 6;
    for (let diskSize = NUM_DISKS; diskSize > 0; diskSize--) {
        towers[0].addDisk(diskSize);
    }

    // Move all to towers[2] via towers[1] which acts as an intemmediate buffer
    towers[0].moveAllTo(towers[2], towers[1]);

    console.log(towers[2].numDisks());
}

main();
