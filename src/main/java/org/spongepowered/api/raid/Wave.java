/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.raid;

import org.spongepowered.api.entity.living.monster.raider.Raider;

import java.util.Optional;

public interface Wave {

    /**
     * Gets the {@link Raid} this wave is apart of.
     *
     * @return The raid
     */
    Raid getRaid();

    /**
     * Determines if this wave was a bonus of the {@link Raid}.
     *
     * @return True if bonus, false if not
     */
    boolean isBonus();

    /**
     * Determines if this wave was the final wave of the {@link Raid}.
     *
     * @return True if the final wave, false if not
     */
    boolean isFinal();

    /**
     * Gets the {@link Raider leader} of this wave.
     *
     * @return The leader or {@link Optional#empty()} if not present
     */
    Optional<Raider> getLeader();

    /**
     * Adds a {@link Raider} to this wave.
     *
     * @param raider The raider
     * @param addToRaidHealth Whether to add on to a {@link Raid Raid's} health
     * @return True if raider was added, false if not
     */
    boolean addRaider(Raider raider, boolean addToRaidHealth);

    /**
     * Removes a {@link Raider} from this wave.
     *
     * @param raider The raider to remove
     * @return True if remove succeeded, false if not (or wasn't in the wave to begin with)
     */
    boolean removeRaider(Raider raider);
}