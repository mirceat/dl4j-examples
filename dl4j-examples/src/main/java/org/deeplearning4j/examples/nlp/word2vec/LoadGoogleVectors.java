package org.deeplearning4j.examples.nlp.word2vec;

import java.io.File;
import org.deeplearning4j.util.SerializationUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;

/**
 * Created by agibsonccc on 5/25/14.
 * 
 * Appends vectors to words (one per line, tab separated).
 * 
 */
public class LoadGoogleVectors {

    public static void main(String[] args) throws Exception {
        // read model
        File gModel = new File("/shared/GoogleNews-vectors-negative300.bin.gz");
        // File gModel = new File("/similarity/models/GoogleNews-vectors-negative300.bin.gz");
        WordVectors vec = WordVectorSerializer.loadGoogleModel(gModel, true);
        
        // read words one per line     
    	InputStream is = System.in;
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));

		String line = buf.readLine();
		while (line != null) {
		    // get vector
            double[] wordVector = vec.getWordVector( line );
        
            if ( wordVector != null ) {
                System.out.print( line );
                for ( double d : wordVector ) {
                    System.out.print( "\t" + d );
                }
                System.out.println();
            }

			line = buf.readLine();
		}
    }
}
