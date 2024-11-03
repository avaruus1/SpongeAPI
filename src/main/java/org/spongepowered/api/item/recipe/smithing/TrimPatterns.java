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
package org.spongepowered.api.item.recipe.smithing;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.ENGINE)
public final class TrimPatterns {

    public static final DefaultedRegistryReference<TrimPattern> BOLT = TrimPatterns.key(ResourceKey.minecraft("bolt"));

    public static final DefaultedRegistryReference<TrimPattern> COAST = TrimPatterns.key(ResourceKey.minecraft("coast"));

    public static final DefaultedRegistryReference<TrimPattern> DUNE = TrimPatterns.key(ResourceKey.minecraft("dune"));

    public static final DefaultedRegistryReference<TrimPattern> EYE = TrimPatterns.key(ResourceKey.minecraft("eye"));

    public static final DefaultedRegistryReference<TrimPattern> FLOW = TrimPatterns.key(ResourceKey.minecraft("flow"));

    public static final DefaultedRegistryReference<TrimPattern> HOST = TrimPatterns.key(ResourceKey.minecraft("host"));

    public static final DefaultedRegistryReference<TrimPattern> RAISER = TrimPatterns.key(ResourceKey.minecraft("raiser"));

    public static final DefaultedRegistryReference<TrimPattern> RIB = TrimPatterns.key(ResourceKey.minecraft("rib"));

    public static final DefaultedRegistryReference<TrimPattern> SENTRY = TrimPatterns.key(ResourceKey.minecraft("sentry"));

    public static final DefaultedRegistryReference<TrimPattern> SHAPER = TrimPatterns.key(ResourceKey.minecraft("shaper"));

    public static final DefaultedRegistryReference<TrimPattern> SILENCE = TrimPatterns.key(ResourceKey.minecraft("silence"));

    public static final DefaultedRegistryReference<TrimPattern> SNOUT = TrimPatterns.key(ResourceKey.minecraft("snout"));

    public static final DefaultedRegistryReference<TrimPattern> SPIRE = TrimPatterns.key(ResourceKey.minecraft("spire"));

    public static final DefaultedRegistryReference<TrimPattern> TIDE = TrimPatterns.key(ResourceKey.minecraft("tide"));

    public static final DefaultedRegistryReference<TrimPattern> VEX = TrimPatterns.key(ResourceKey.minecraft("vex"));

    public static final DefaultedRegistryReference<TrimPattern> WARD = TrimPatterns.key(ResourceKey.minecraft("ward"));

    public static final DefaultedRegistryReference<TrimPattern> WAYFINDER = TrimPatterns.key(ResourceKey.minecraft("wayfinder"));

    public static final DefaultedRegistryReference<TrimPattern> WILD = TrimPatterns.key(ResourceKey.minecraft("wild"));

    private TrimPatterns() {
    }

    public static Registry<TrimPattern> registry() {
        return Sponge.server().registry(RegistryTypes.TRIM_PATTERN);
    }

    private static DefaultedRegistryReference<TrimPattern> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.TRIM_PATTERN, location).asDefaultedReference(Sponge::server);
    }
}
