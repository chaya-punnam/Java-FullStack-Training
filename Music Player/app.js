const PlayIcon = document.getElementById("play");
const AudioFile = document.getElementById("audio");

let isAudioPlaying = false;

function play()
{
    AudioFile.play();
    PlayIcon.classList.replace("fa-play", "fa-pause");
    isAudioPlaying = true;
}

function pause()
{
    AudioFile.pause();
    PlayIcon.classList.replace("fa-pause", "fa-play");
    isAudioPlaying = false;
}

PlayIcon.addEventListener("click", function()
{
    if(isAudioPlaying)
    {
        pause();
    }
    else
    {
        play();
    }
});

const songsDetails = [
    {
        image: "./IMAGES/image-2.jpg",
        songName: "DEF SONG",
        singerName: "DEF SINGER",
        audio: "./AUDIO/music-2.mp3"
    },
    {
        image: "./IMAGES/image-3.jpg",
        songName: "PQR SONG",
        singerName: "PQR SINGER",
        audio: "./AUDIO/music-3.mp3"
    },
    {
        image: "./IMAGES/image-4.jpg",
        songName: "XYZ SONG",
        singerName: "XYZ SINGER",
        audio: "./AUDIO/music-4.mp3"
    },
    {
        image: "./IMAGES/image-1.jpg",
        songName: "ABC SONG",
        singerName: "ABC SINGER",
        audio: "./AUDIO/music-1.mp3"
    }
];

const SongH2 = document.getElementById("songname");
const SingerH3 = document.getElementById("singername");
const SongImg = document.getElementById("songimage");

const Movable = document.getElementById("movable");

const CurrentTimeEle = document.getElementById("currentTime");
const DurationEle = document.getElementById("duration");

const ForwardButton = document.getElementById("forward");
const BackwardButton = document.getElementById("backward");

const HeartEle = document.getElementById("heart");

let songIndex = 0;

function updateHeart()
{
    if(localStorage.getItem(SongH2.textContent))
    {
        HeartEle.style.color = "red";
    }
    else
    {
        HeartEle.style.color = "black";
    }
}

function loadSong(songIndex)
{
    SongImg.src = songsDetails[songIndex].image;
    SongH2.textContent = songsDetails[songIndex].songName;
    SingerH3.textContent = songsDetails[songIndex].singerName;
    AudioFile.src = songsDetails[songIndex].audio;

    updateHeart();

    AudioFile.load();
    play();
}

function nextSong()
{
    songIndex++;

    if(songIndex >= songsDetails.length)
    {
        songIndex = 0;
    }

    loadSong(songIndex);
}

ForwardButton.addEventListener("click", nextSong);

function previousSong()
{
    songIndex--;

    if(songIndex < 0)
    {
        songIndex = songsDetails.length - 1;
    }

    loadSong(songIndex);
}

BackwardButton.addEventListener("click", previousSong);

AudioFile.addEventListener("timeupdate", function()
{
    let currentTime = AudioFile.currentTime;
    let duration = AudioFile.duration;

    if(!duration)
    {
        return;
    }

    let percentage = (currentTime / duration) * 100;

    Movable.style.width = percentage + "%";

    let currentMinutes = Math.floor(currentTime / 60);
    let currentSeconds = Math.floor(currentTime % 60);

    let durationMinutes = Math.floor(duration / 60);
    let durationSeconds = Math.floor(duration % 60);

    if(currentSeconds < 10)
    {
        currentSeconds = "0" + currentSeconds;
    }

    if(durationSeconds < 10)
    {
        durationSeconds = "0" + durationSeconds;
    }

    CurrentTimeEle.textContent =
    currentMinutes + ":" + currentSeconds;

    DurationEle.textContent =
    durationMinutes + ":" + durationSeconds;
});

AudioFile.addEventListener("ended", function()
{
    nextSong();
});

HeartEle.addEventListener("click", function()
{
    if(localStorage.getItem(SongH2.textContent))
    {
        localStorage.removeItem(SongH2.textContent);
        HeartEle.style.color = "black";
    }
    else
    {
        localStorage.setItem(
            SongH2.textContent,
            SingerH3.textContent
        );

        HeartEle.style.color = "red";
    }
});

updateHeart();

const shuffleButton=document.getElementById("shuffle");
shuffleButton.addEventListener("click", function()
{
    let songIndex =
    Math.floor(Math.random() * 4);

    loadSong(songIndex);
});