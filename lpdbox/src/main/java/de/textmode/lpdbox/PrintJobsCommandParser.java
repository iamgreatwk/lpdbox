package de.textmode.lpdbox;

/*
 * Copyright 2017 Michael Knigge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;

/**
 * The {@link PrintJobsCommandParser} parses the daemon command "Print any waiting jobs"
 * and sends the response back to the client.
 */
final class PrintJobsCommandParser extends CommandParser {

    /**
     * Constructor.
     */
    PrintJobsCommandParser(final Logger logger, final DaemonCommandHandler handler) {
        super(logger, handler);
    }

    /**
     * Parses the daemon command "Print any waiting jobs" and delegates the work to
     * the {@link DaemonCommandHandler}.
     */
    @Override
    void parse(final InputStream is, final OutputStream os) throws IOException {
        this.getDaemonCommandHandler().printJobs(this.getQueueName(is));
    }
}
