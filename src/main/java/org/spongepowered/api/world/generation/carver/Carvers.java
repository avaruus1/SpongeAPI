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
package org.spongepowered.api.world.generation.carver;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * <!-- This file is automatically generated. Any manual changes will be overwritten. -->
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.ENGINE)
public final class Carvers {

    // @formatter:off
    public static final DefaultedRegistryReference<Carver> CANYON = Carvers.key(ResourceKey.minecraft("canyon"));

    public static final DefaultedRegistryReference<Carver> CAVE = Carvers.key(ResourceKey.minecraft("cave"));

    public static final DefaultedRegistryReference<Carver> CAVE_EXTRA_UNDERGROUND = Carvers.key(ResourceKey.minecraft("cave_extra_underground"));

    public static final DefaultedRegistryReference<Carver> NETHER_CAVE = Carvers.key(ResourceKey.minecraft("nether_cave"));

    // @formatter:on
    private Carvers() {
    }

    public static Registry<Carver> registry() {
        return Sponge.server().registry(RegistryTypes.CARVER);
    }

    private static DefaultedRegistryReference<Carver> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.CARVER, location).asDefaultedReference(Sponge::server);
    }
}
