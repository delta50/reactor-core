/*
 * Copyright (c) 2011-2017 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.core.publisher;

import org.reactivestreams.Publisher;
import reactor.core.CoreSubscriber;

/**
 * A connecting {@link Mono} Publisher (right-to-left from a composition chain
 * perspective)
 *
 * @param <I> Upstream type
 */
/*
 * The following comment is a operator codification meant to be searchable.
 * See https://github.com/reactor/reactor-core/issues/1673 for a
 * complete description of each element codified and the associated values.
 *
 * {REQUEST_SHAPING}: NONE
 * {PREFETCH}: NONE
 * {BUFFERING}: NONE
 * {GEOMETRY}: 1-1
 * ^ assumes Flux has Mono semantics
 * {SOURCE}: FLUX
 */
final class MonoSourceFlux<I> extends MonoFromFluxOperator<I, I> {


	/**
	 * Build a {@link MonoSourceFlux} wrapper around the passed parent {@link Flux}
	 *
	 * @param source the {@link Flux} to decorate
	 */
	MonoSourceFlux(Flux<? extends I> source) {
		super(source);
	}

	/**
	 * Default is simply delegating and decorating with {@link Mono} API. Note this
	 * assumes an identity between input and output types.
	 * @param actual
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void subscribe(CoreSubscriber<? super I> actual) {
		source.subscribe(actual);
	}

}
