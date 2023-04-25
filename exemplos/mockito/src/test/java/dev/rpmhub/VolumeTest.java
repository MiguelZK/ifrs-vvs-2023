package dev.rpmhub;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VolumeTest {

    // 1 - Crie um mock da classe AudioManager
    @Mock
    private AudioManager audioManager;

    // 2 - injete um mock da classe VolumeUtil
    @InjectMocks
    private VolumeUtil volumeUtil;

    @Test
    public void testAudioManagerSetVolume() {
        // 3 - realize uma chamada para o método maximizeVolume do objeto VolumeUtil
        volumeUtil.maximizeVolume(70);
        // 4 - Verifique se o método setVolume foi chamado uma única vez
        verify(audioManager, times(1)).setVolume(anyInt());
    }

}