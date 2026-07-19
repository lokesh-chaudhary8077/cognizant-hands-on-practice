import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Sachin", score: 90 },
        { name: "Virat", score: 85 },
        { name: "Dhoni", score: 65 },
        { name: "Rohit", score: 75 },
        { name: "Rahul", score: 55 },
        { name: "Hardik", score: 80 },
        { name: "Jadeja", score: 60 },
        { name: "Gill", score: 95 },
        { name: "Pant", score: 68 },
        { name: "Shami", score: 72 },
        { name: "Bumrah", score: 50 }
    ];

    const lowScorePlayers = players.filter(player => player.score < 70);

    return (
        <div style={{ marginLeft: "20px" }}>

            <h1>List of Players</h1>

            <h2>All Players</h2>

            <ul>
                {players.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

            <h2>Players having score less than 70</h2>

            <ul>
                {lowScorePlayers.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

        </div>
    );
}

export default ListofPlayers;