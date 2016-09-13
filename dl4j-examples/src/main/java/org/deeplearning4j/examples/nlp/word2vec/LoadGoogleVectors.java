package org.deeplearning4j.examples.nlp.word2vec;

import org.deeplearning4j.util.SerializationUtils;
// import org.deeplearning4j.word2vec.Word2Vec;
// import org.deeplearning4j.word2vec.loader.Word2VecLoader;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;


import java.io.File;

/**
 * Created by agibsonccc on 5/25/14.
 */
public class LoadGoogleVectors {

    public static void main(String[] args) throws Exception {
        // Word2Vec vec = Word2VecLoader.loadGoogleModel("/similarity/models/GoogleNews-vectors-negative300.bin.gz");
        Word2Vec vec = WordVectorSerializer.loadFullModel("/similarity/models/GoogleNews-vectors-negative300.bin.gz");
        SerializationUtils.saveObject(vec,new File("/similarity/resultGoogle"));

        // Word2Vec vec = SerializationUtils.readObject(new File("mypath"));

        float[] wordVector = vec.getWordVector("company");
        
        for ( float f :wordVector ) {
            Sysyem.out.println( f );
        }
    }
}
