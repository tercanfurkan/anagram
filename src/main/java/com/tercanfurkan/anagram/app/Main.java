package com.tercanfurkan.anagram.app;

import com.tercanfurkan.anagram.processor.ProcessorFactory;
import com.tercanfurkan.anagram.processor.ProcessorFactory.ProcessorType;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

public class Main {

    private static final String PROCESSOR_TYPE_KEY = "PROCESSOR_TYPE";
    private static final ProcessorType DEFAULT_PROCESSOR_TYPE = ProcessorType.SORTING;

    public static void main(String[] args) {
        var anagramProcessor = ProcessorFactory.initProcessor(getProcessorType());
        var anagramChecker = new AnagramCheckerCLI(System.in, System.out, anagramProcessor);
        anagramChecker.run();
    }

    private static ProcessorType getProcessorType() throws DotenvException {
        ProcessorType processorType = DEFAULT_PROCESSOR_TYPE;
        try {
            var dotEnv = Dotenv.configure().load();
            processorType = ProcessorType.valueOf(dotEnv.get(PROCESSOR_TYPE_KEY, DEFAULT_PROCESSOR_TYPE.toString()));
            System.out.printf("%s anagram processor is selected\n", processorType);
        } catch(IllegalArgumentException e) {
            System.out.printf("Selected processor type is invalid. %s anagram processor is selected as default\n", processorType);
        }
        return processorType;
    }
}
